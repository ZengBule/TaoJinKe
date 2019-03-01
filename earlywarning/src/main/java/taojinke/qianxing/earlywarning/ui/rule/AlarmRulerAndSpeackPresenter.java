package taojinke.qianxing.earlywarning.ui.rule;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import taojinke.qianxing.core.NetworkInfoUtils;
import taojinke.qianxing.earlywarning.ui.rule.vb.report.ServiceReport;
import taojinke.qianxing.earlywarning.ui.rule.vb.report.ServiceReportViewBinder;
import taojinke.qianxing.earlywarning.ui.rule.vb.report.Warning;
import taojinke.qianxing.earlywarning.ui.rule.vb.report.WarningViewBinder;
import taojinke.qianxing.earlywarning.ui.rule.vb.rule.RuleAndSpeak;
import taojinke.qianxing.earlywarning.ui.rule.vb.rule.RuleAndSpeakViewBinder;
import taojinke.qianxing.lib_kernel.http.BaseBean;
import taojinke.qianxing.lib_kernel.http.net.rx.RxRestClient;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;

import static taojinke.qianxing.core.Constant.WEB_TOKEN_KEY;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.earlywarning.ui.rule
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/1+16:27
 * 修改人：
 * 修改时间：2019/3/1+16:27
 * 修改备注：
 * ***********************************************
 */
public class AlarmRulerAndSpeackPresenter implements AlarmRulerAndSpeackContract.IAlarmRulerAndSpeackPresenter {
    @Inject
    AlarmRulerAndSpeackContract.IAlarmRulerAndSpeackView mView;
    private Items ruleItems;
    private Items reportItems;

    private MultiTypeAdapter ruleAdapter;
    private MultiTypeAdapter reportAdapter;

    @Override
    public void getAlarmRuleSpeak() {
        if (NetworkInfoUtils.isNetworkConnected(mView.fetchContext())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(WEB_TOKEN_KEY, SharedPreferenceUtils.getReqToken(mView.fetchContext()));
            RxRestClient.create()
                    .url("/tjkjobtaskApi/manualRule/queryWarningHelpDocument")
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

                            BaseBean value = JSON.parseObject(s, BaseBean.class);

                            if (value.isSuccess()) {
                                String data = JSON.toJSONString(value.getData());
                                if (!TextUtils.isEmpty(data)) {
                                    RuleAndSpeak ruleAndSpeak = JSON.parseObject(data, RuleAndSpeak.class);
                                    ruleItems.addAll(ruleAndSpeak.getWarningCardList());
                                    ruleAdapter.notifyDataSetChanged();
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
            mView.showToast("网络异常");

        }
    }

    @Override
    public void getServiceReport() {
        if (NetworkInfoUtils.isNetworkConnected(mView.fetchContext())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(WEB_TOKEN_KEY, SharedPreferenceUtils.getReqToken(mView.fetchContext()));
            RxRestClient.create()
                    .url("/tjkjobtaskApi/manualRule/queryReportHelpDocument")
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

                            BaseBean value = JSON.parseObject(s, BaseBean.class);
                            if (value.isSuccess()) {
                                String data = JSON.toJSONString(value.getData());
                                if (!TextUtils.isEmpty(data)) {
                                    ServiceReport serviceReport = JSON.parseObject(data, ServiceReport.class);
                                    reportItems.addAll(serviceReport.getReportCardList());
                                    reportAdapter.notifyDataSetChanged();
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
            mView.showToast("网络异常");

        }
    }

    @Override
    public MultiTypeAdapter getAlarmRuleSpeakAdapter() {
        ruleItems = new Items();
        ruleAdapter = new MultiTypeAdapter(ruleItems);
        ruleAdapter.register(RuleAndSpeak.WarningCardListBean.class, new RuleAndSpeakViewBinder(mView.fetchContext()));

        return ruleAdapter;
    }

    @Override
    public MultiTypeAdapter getServiceReportAdapter() {
        reportItems = new Items();
        reportAdapter = new MultiTypeAdapter(reportItems);
        reportAdapter.register(ServiceReport.ReportCardListBean.class, new ServiceReportViewBinder(mView.fetchContext()));
        reportAdapter.register(Warning.class, new WarningViewBinder());
        return reportAdapter;
    }
}
