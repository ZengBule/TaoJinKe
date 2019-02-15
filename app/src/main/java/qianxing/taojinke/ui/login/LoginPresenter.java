package qianxing.taojinke.ui.login;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import taojinke.qianxing.lib_kernel.http.net.rx.RxRestClient;


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
