package taojinke.qianxing.earlywarning.ui.executing;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.inject.Inject;

import androidx.core.content.ContextCompat;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import taojinke.qianxing.core.NetworkInfoUtils;
import taojinke.qianxing.earlywarning.R;
import taojinke.qianxing.earlywarning.ui.executing.pw.one.TypeDataOne;
import taojinke.qianxing.earlywarning.ui.executing.pw.one.TypeDataOneViewBinder;
import taojinke.qianxing.earlywarning.ui.executing.pw.three.RediuceAlarm;
import taojinke.qianxing.earlywarning.ui.executing.pw.three.RediuceAlarmViewBinder;
import taojinke.qianxing.earlywarning.ui.executing.pw.two.AlarmContentData;
import taojinke.qianxing.earlywarning.ui.executing.pw.two.AlarmContentDataIncludeView;
import taojinke.qianxing.earlywarning.ui.executing.pw.two.AlarmContentDataViewBinder;
import taojinke.qianxing.earlywarning.ui.executing.store.AlarmInfo;
import taojinke.qianxing.earlywarning.ui.executing.store.AlarmInfoViewBinder;
import taojinke.qianxing.earlywarning.ui.executing.store.StoreInfo;
import taojinke.qianxing.earlywarning.ui.executing.store.StoreInfoIncludeView;
import taojinke.qianxing.earlywarning.ui.executing.store.StoreInfoViewBinder;
import taojinke.qianxing.lib_kernel.http.BaseBean;
import taojinke.qianxing.lib_kernel.http.net.rx.RxRestClient;
import taojinke.qianxing.lib_kernel.http.net.rx.databus.RxBus;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;
import taojinke.qianxing.lib_weight.countdownview.CountdownView;
import taojinke.qianxing.lib_weight.pw.CommonPopupWindow;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.earlywarning.ui.executing
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/1+10:11
 * 修改人：
 * 修改时间：2019/3/1+10:11
 * 修改备注：
 * ***********************************************
 */
public class TaskExecutingPresenter implements TaskExecutingContract.ITaskExecutingPresenter {
    @Inject
    TaskExecutingContract.ITaskExecutingView mView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;
    private Items mAlarms;

    @Override
    public void tryLoadData() {

        if (NetworkInfoUtils.isNetworkConnected(mView.fetchContext())) {
            String url = "/tjkInfo/serviceInfo/getWorkInfo";
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("tjk_login_token", SharedPreferenceUtils.getReqToken(mView.fetchContext()));
            RxRestClient.create()
                    .url(url)
                    .params(hashMap)
                    .build()
                    .postQuery()
                    .compose(mView.bindLifecycleAndThreadWithLoading())
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(String s) {
                            //把原有线程取消掉 防止内存溢出
                            for (int i = 0; i < mItems.size(); i++) {
                                StoreInfoIncludeView storeInfoIncludeView = (StoreInfoIncludeView) mItems.get(i);
                                storeInfoIncludeView.getCountdownView().getManager().getTimeTimer().cancel();
                            }
                            mItems.clear();
                            mView.stopRefresh();

                            BaseBean value = JSON.parseObject(s, BaseBean.class);

                            if (value.isSuccess()) {
                                mView.showNormal();
                                String data = JSON.toJSONString(value.getData());
                                if (!TextUtils.isEmpty(data)) {
                                    WorkInfo workInfo = JSON.parseObject(data, WorkInfo.class);
                                    showStatusView(workInfo);

                                    if (workInfo.getShopList() != null && workInfo.getShopList().size() > 0) {
                                        fillterStatusAndShopData(workInfo);
                                    } else if (TextUtils.equals(workInfo.getServiceState(), "OutOfService")) {
                                        fillterStatusAndShopData(workInfo);
                                    }
                                    if (workInfo.getWarningMessages() != null && workInfo.getWarningMessages().size() > 0) {
                                        dealWithWaringData(workInfo);
                                        if (TextUtils.equals(workInfo.getServiceState(), "OutOfService")) {
                                            mView.showBottomLayout(false, workInfo.getServiceState());
                                        } else {
                                            mView.showBottomLayout(true, workInfo.getServiceState());
                                        }

                                    } else {
                                        mView.showBottomLayout(false, workInfo.getServiceState());
                                    }

                                } else {
                                    mView.showEmpty("暂无任务\n" + "去待完成任务里面查询吧");
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });


        } else {
            mView.showNoNetwork();
        }

    }


    /**
     * 状态信息以及商铺
     */
    private void fillterStatusAndShopData(WorkInfo workInfo) {

        if (TextUtils.equals(workInfo.getServiceState(), "OutOfService")) {
            AlarmInfo info = new AlarmInfo();
            info.setPutOn(workInfo.isPutOn());
            mItems.add(info);
        } else {
            for (int i = 0; i < workInfo.getShopList().size(); i++) {
                StoreInfoIncludeView infoIncludeVie = new StoreInfoIncludeView();
                StoreInfo info = workInfo.getShopList().get(i);
                infoIncludeVie.setStoreInfo(info);
                CountdownView countdownView = new CountdownView(mView.fetchContext());
                countdownView.setTimeFormat(CountdownView.TYPE.M_S_C).setModules(1);
                if (TextUtils.equals(info.getShopState(), "ReadyForService")) {
                    countdownView.setCountdownTime((int) info.getRemainingSchedulingTime(), UUID.randomUUID().toString(), false);
                } else {
                    countdownView.setCountdownTime((int) info.getRemainingSchedulingTime(), UUID.randomUUID().toString(), true);
                }

                countdownView.setTextColor(ContextCompat.getColor(mView.fetchContext(), R.color.FF757575));

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.gravity = Gravity.CENTER_VERTICAL;
                countdownView.setLayoutParams(layoutParams);

                infoIncludeVie.setCountdownView(countdownView);
                mItems.add(infoIncludeVie);
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 预警延迟处理数据
     */

    private void dealWithWaringData(WorkInfo workInfo) {

        for (int i = 0; i < mAlarms.size(); i++) {
            AlarmContentDataIncludeView dataIncludeView = (AlarmContentDataIncludeView) mAlarms.get(i);
            dataIncludeView.getCountdownView().getManager().getTimeTimer().cancel();
        }
        mAlarms.clear();
        TypeDataOne one = new TypeDataOne();
        one.setValue(workInfo.getWarningMessages().size());
        mAlarms.add(one);
        mView.getCountAlarmTextView().setText(String.valueOf(workInfo.getWarningMessages().size()));

        for (int i = 0; i < workInfo.getWarningMessages().size(); i++) {

            AlarmContentDataIncludeView view = new AlarmContentDataIncludeView();

            AlarmContentData alarmContentData = workInfo.getWarningMessages().get(i);
            view.setData(alarmContentData);

            CountdownView countdownView = new CountdownView(mView.fetchContext());
            countdownView.setModules(2);
            countdownView.setTimeFormat(CountdownView.TYPE.ONLY_S_C).setModules(2);
            countdownView.setTextColor(ContextCompat.getColor(mView.fetchContext(), R.color.FF2A2A2A));
            countdownView.setTextSize(COMPLEX_UNIT_DIP, 14);
            TextPaint tp = countdownView.getPaint();
            tp.setFakeBoldText(true);
            countdownView.setCountdownTime((int) alarmContentData.getDuration(), UUID.randomUUID().toString(), true);
            view.setCountdownView(countdownView);

            mAlarms.add(view);
        }
        RediuceAlarm alarm = new RediuceAlarm();
        alarm.setVlaue(workInfo.getUnConfirmedNumber());
        mAlarms.add(alarm);
    }

    /**
     * 展示状态View
     *
     * @param workInfo data
     */
    private void showStatusView(WorkInfo workInfo) {

        mView.getIncomeTextView().setText("¥");
        mView.getIncomeTextView().append(String.valueOf(workInfo.getForecastEarnings()));

        switch (workInfo.getServiceState()) {
            case "ReadyForService":
                mView.getTaskStatus().setText("待服务");
                mView.getLongTime().setText("服务倒计时");
                mView.getHintText().setVisibility(View.GONE);
                mView.getCountdownView().setTimeFormat(CountdownView.TYPE.M_S_C).setModules(1);
                mView.getCountdownView().setCountdownTime(workInfo.getServiceTime(), UUID.randomUUID().toString(), true);
                mView.getServiceStatusLinearLayout().setBackgroundColor(Color.parseColor("#5B5B5B"));

                break;
            case "NoService":
                mView.showEmpty("暂无任务\n" +
                        "去待完成任务里面查询吧");
                mView.getServiceStatusLinearLayout().setBackgroundColor(ContextCompat.getColor(mView.fetchContext(), R.color.white));
                mView.showBottomLayout(false, workInfo.getServiceState());
                break;
            case "InService":
                mView.getTaskStatus().setText("正在服务中");
                mView.getLongTime().setText("服务累计时长");
                mView.getHintText().setVisibility(View.GONE);
                mView.getCountdownView().setTimeFormat(CountdownView.TYPE.M_S_C).setModules(2);
                mView.getCountdownView().setCountdownTime(workInfo.getServiceTime() + 1, UUID.randomUUID().toString(), true);
                mView.getServiceStatusLinearLayout().setBackgroundColor(Color.parseColor("#77A9FD"));
                break;
            case "PauseService":
                mView.getTaskStatus().setText("服务报备中");
                mView.getLongTime().setText("报备倒计时");
                mView.getHintText().setVisibility(View.GONE);
                mView.getCountdownView().setTimeFormat(CountdownView.TYPE.M_S_C).setModules(1);
                mView.getCountdownView().setCountdownTime(workInfo.getServiceTime() + 1, UUID.randomUUID().toString(), true);
                mView.getServiceStatusLinearLayout().setBackgroundColor(Color.parseColor("#FAAD4B"));
                break;
            case "OutOfService":
                mView.getTaskStatus().setText("离线");
                mView.getHintText().setVisibility(View.VISIBLE);
                if (!TextUtils.isEmpty(workInfo.getReason())) {
                    mView.getHintText().setText(workInfo.getReason());
                }
                mView.getLongTime().setText("已预警停 ");
                mView.getCountdownView().setTimeFormat(CountdownView.TYPE.M_S_C).setModules(2);
                mView.getCountdownView().setCountdownTime(workInfo.getServiceTime() + 1, UUID.randomUUID().toString(), true);
                mView.getServiceStatusLinearLayout().setBackgroundColor(Color.parseColor("#FF6D6D"));
                mView.getDriectIncomeLayout().setVisibility(View.GONE);
                mView.showBottomLayout(false, workInfo.getServiceState());

                break;

            default:
        }

        RxBus.getInstance().send(workInfo.getServiceState());
    }

    @Override
    public MultiTypeAdapter getAdapter() {
        mItems = new Items();
        mAlarms = new Items();
        mAdapter = new MultiTypeAdapter(mItems);
        mAdapter.register(StoreInfoIncludeView.class, new StoreInfoViewBinder(mView.fetchContext()));
        mAdapter.register(AlarmInfo.class, new AlarmInfoViewBinder(mView.fetchContext()));
        return mAdapter;
    }

    @Override
    public CommonPopupWindow createPopupWindow() {
        ArrayList<Class> items = new ArrayList<>();
        items.add(TypeDataOne.class);
        items.add(AlarmContentDataIncludeView.class);
        items.add(RediuceAlarm.class);

        ArrayList<ItemViewBinder> binders = new ArrayList<>();
        TypeDataOneViewBinder oneViewBinder = new TypeDataOneViewBinder();
        RediuceAlarmViewBinder rediuceAlarmViewBinder = new RediuceAlarmViewBinder();
        AlarmContentDataViewBinder alarmContentDataViewBinder = new AlarmContentDataViewBinder();
        binders.add(oneViewBinder);
        binders.add(alarmContentDataViewBinder);
        binders.add(rediuceAlarmViewBinder);
        return new CommonPopupWindow(mView.fetchContext(), items, binders);
    }

    @Override
    public Items getAlarmData() {
        return mAlarms;
    }
}
