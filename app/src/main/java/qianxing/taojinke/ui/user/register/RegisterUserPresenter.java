package qianxing.taojinke.ui.user.register;

import com.alibaba.fastjson.JSON;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import taojinke.qianxing.core.DESUtil;
import taojinke.qianxing.lib_kernel.http.BaseBean;
import taojinke.qianxing.lib_kernel.http.net.rx.RxRestClient;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.user.register
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/18+18:06
 * 修改人：
 * 修改时间：2019/2/18+18:06
 * 修改备注：
 * ***********************************************
 */
public class RegisterUserPresenter implements RegisterUserContract.IRegisterUserPresenter {
    @Inject
    RegisterUserContract.IRegisterUserView mView;

    @Override
    public void sendRegisterSMS(String deviceId, String phoneNumber) {
        HashMap<String, Object> map = new HashMap<>();
        String signature = null;
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("phoneNumber", phoneNumber);
            jsonObject.put("deviceId", deviceId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            signature = DESUtil.encrypt(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("signature", signature);
        RxRestClient.create()
                .url("tjuser/SMS/sendRegisterSMS")
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
                        BaseBean baseBean = JSON.parseObject(s, BaseBean.class);
                        if (baseBean.isSuccess()) {
                            mView.goToIdentifyCodeActivity(phoneNumber);
                        } else {
                            mView.showToast(baseBean.getMessage());
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
