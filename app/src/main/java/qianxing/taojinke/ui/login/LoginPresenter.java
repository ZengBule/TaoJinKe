package qianxing.taojinke.ui.login;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import taojinke.qianxing.lib_kernel.http.BaseBean;
import taojinke.qianxing.lib_kernel.http.net.rx.RxRestClient;
import taojinke.qianxing.lib_kernel.model.LoginUserBean;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.login
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/15+14:44
 * 修改人：
 * 修改时间：2019/2/15+14:44
 * 修改备注：
 * ***********************************************
 */
public class LoginPresenter implements LoginContract.ILoginPresenter {
    @Inject
    LoginContract.ILoginView mView;

    @Override
    public void loginTjk(String user, String password) {
        String url = "customer/action/app/noauth/login";
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("login_name", user);
        map.put("login_pwd", password);
        RxRestClient.create()
                .url(url)
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
                        if (baseBean.isStatus()) {
                            String data = JSON.toJSONString(baseBean.getData());
                            LoginUserBean loginUserBean = JSON.parseObject(data, LoginUserBean.class);
                            mView.saveUserInfo(loginUserBean);
                            SharedPreferenceUtils.saveisLoginPerference(mView.fetchContext(), "yes");
                            mView.refreshUI(true);
                        } else {
                            SharedPreferenceUtils.saveisLoginPerference(mView.fetchContext(), "no");
                            mView.refreshUI(false);
                            if (!TextUtils.isEmpty(baseBean.getMessage())) {
                                mView.showToast(baseBean.getMessage());
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
