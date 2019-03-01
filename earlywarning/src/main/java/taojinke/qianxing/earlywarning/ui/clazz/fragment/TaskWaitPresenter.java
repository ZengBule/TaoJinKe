package taojinke.qianxing.earlywarning.ui.clazz.fragment;

import android.content.Context;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import taojinke.qianxing.core.DateUtil;
import taojinke.qianxing.earlywarning.ui.HaveWaitingCompletData;
import taojinke.qianxing.earlywarning.ui.clazz.fragment.adapter.PlanTaskBean;
import taojinke.qianxing.earlywarning.ui.clazz.fragment.adapter.TaskWaitViewBinder;
import taojinke.qianxing.lib_kernel.http.BaseBean;
import taojinke.qianxing.lib_kernel.http.net.rx.RxRestClient;
import taojinke.qianxing.lib_kernel.http.net.rx.databus.RxBus;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;

import static taojinke.qianxing.core.Constant.WEB_TOKEN_KEY;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.earlywarning.ui.clazz.fragment
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/1+15:37
 * 修改人：
 * 修改时间：2019/3/1+15:37
 * 修改备注：
 * ***********************************************
 */
public class TaskWaitPresenter implements TaskWaitContract.ITaskWaitPresenter {
    @Inject
    TaskWaitContract.ITaskWaitView mView;

    private MultiTypeAdapter adapter;
    private Items items;

    @Override
    public void tryLoadData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(WEB_TOKEN_KEY, SharedPreferenceUtils.getReqToken(mView.fetchContext()));
        String time = DateUtil.getNowTime("yyyy-MM-dd HH:mm:ss");
        map.put("startTime", time);

        RxRestClient.create()
                .url("tjkjobtaskApi/task/getPlanTask")
                .params(map)
                .build()
                .postQuery()
                .compose(mView.bindLifecycleAndThreadWithLoading())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        mView.stopRefresh();
                        BaseBean value = JSON.parseObject(s, BaseBean.class);

                        HaveWaitingCompletData completData = new HaveWaitingCompletData();
                        if (value.isSuccess()) {
                            mView.showNormal();
                            List<PlanTaskBean> list = JSON.parseArray(JSON.toJSONString(value.getData()), PlanTaskBean.class);
                            if (list == null || 0 == list.size()) {
                                mView.showEmpty();
                                completData.setHaveData("no");
                                RxBus.getInstance().send(completData);
                                return;
                            }
                            String time = "";
                            for (PlanTaskBean bean : list) {
                                if (bean.getTaskId() != null && bean.getTaskId().equals("-1")) {
                                    list.remove(bean);
                                    continue;
                                }
                                if (bean.getWorkTimeStr() != null) {
                                    String start = bean.getStartTime().substring(0, bean.getStartTime().indexOf(" "));
                                    if (!start.equals(time)) {
                                        bean.setShowTitle(true);
                                        time = start;
                                    }
                                }
                            }
                            completData.setHaveData("yes");
                            RxBus.getInstance().send(completData);

                            items.clear();
                            items.addAll(list);
                            adapter.notifyDataSetChanged();
                        } else {
                            mView.showEmpty();
                            completData.setHaveData("no");
                            RxBus.getInstance().send(completData);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                        HaveWaitingCompletData completData = new HaveWaitingCompletData();
                        completData.setHaveData("no");
                        RxBus.getInstance().send(completData);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getServiceHours() {
        String url = "/tjkInfo/serviceInfo/getTjkServiceHours";
        HashMap<String, Object> map = new HashMap<>();
        map.put(WEB_TOKEN_KEY, SharedPreferenceUtils.getReqToken(mView.fetchContext()));

        RxRestClient.create()
                .url(url)
                .params(map)
                .build()
                .postQuery()
                .compose(mView.bindLifecycleAndThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        mView.stopRefresh();
                        BaseBean baseBean = JSON.parseObject(s, BaseBean.class);
                        if (baseBean.isSuccess()) {
                            String data = JSON.toJSONString(baseBean.getData());
                            mView.getServiceHoursNum(data);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public MultiTypeAdapter getAdapter() {
        items = new Items();
        adapter = new MultiTypeAdapter(items);
        adapter.register(PlanTaskBean.class, new TaskWaitViewBinder(mView.fetchContext()));
        return adapter;
    }
}
