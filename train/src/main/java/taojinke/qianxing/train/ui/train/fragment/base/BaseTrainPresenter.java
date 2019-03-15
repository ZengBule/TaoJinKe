package taojinke.qianxing.train.ui.train.fragment.base;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import taojinke.qianxing.lib_kernel.http.BaseBean;
import taojinke.qianxing.lib_kernel.http.net.rx.RxRestClient;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;
import taojinke.qianxing.train.ui.train.fragment.base.bean.MajorsIndexBean;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.ui.train.fragment.base
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/7+18:07
 * 修改人：
 * 修改时间：2019/3/7+18:07
 * 修改备注：
 * ***********************************************
 */
public class BaseTrainPresenter implements BaseTrainContract.IBaseTrainPresenter {
    @Inject
    BaseTrainContract.IBaseTrainView mView;

    @Override
    public void getMajorIndex() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("tjk_login_token", SharedPreferenceUtils.getReqToken(mView.fetchContext()));
        RxRestClient.create()
                .url("college/majors/index")
                .params(hashMap)
                .build()
                .postQuery()
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
                                MajorsIndexBean majorsIndexBean = JSON.parseObject(data, MajorsIndexBean.class);
                                mView.doFragmentEvent(majorsIndexBean);
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

    }
}
