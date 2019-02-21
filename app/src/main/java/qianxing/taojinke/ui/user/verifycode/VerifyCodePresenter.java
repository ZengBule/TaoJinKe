package qianxing.taojinke.ui.user.verifycode;

import android.util.Log;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import taojinke.qianxing.lib_kernel.http.net.rx.RxRestClient;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.user.verifycode
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/18+16:47
 * 修改人：
 * 修改时间：2019/2/18+16:47
 * 修改备注：
 * ***********************************************
 */
public class VerifyCodePresenter implements VerifyCodeContract.IVerifyCodePresenter {
    @Inject
    VerifyCodeContract.IVerifyCodeView mView;

    @Override
    public void keyRegisterUser(String phone, String code) {
        String url = "tjuser/register/checkCode";
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("phone", phone);
        hashMap.put("code", code);

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
                        Log.v("TAG", s);
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
    public void keyUpdateBindPhone(String code) {

        String url = "customer/action/app/checkCodeByLoginPhone";

        HashMap<String, Object> hashMap = new HashMap<>();
        String token = SharedPreferenceUtils.getPreference("Token", "token", mView.fetchContext());
        hashMap.put("tjk_app_token", token);
        hashMap.put("code", code);
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
                        Log.v("TAG", s);
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
    public void keyBindNewPhone(String phone, String code) {
        String url = "customer/action/app/updatePhone";

        HashMap<String, Object> hashMap = new HashMap<>();
        String token = SharedPreferenceUtils.getPreference("Token", "token", mView.fetchContext());
        hashMap.put("tjk_app_token", token);
        hashMap.put("code", code);
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
                        Log.v("TAG", s);
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
    public void keyUpdateLoginPassword(String phone, String code) {
        String url = "customer/action/app/noauth/smsVerify";
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("phone", phone);
        hashMap.put("code", code);
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
