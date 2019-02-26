package taojinke.qianxing.train;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import taojinke.qianxing.lib_kernel.http.BaseBean;
import taojinke.qianxing.lib_kernel.http.net.rx.RxRestClient;
import taojinke.qianxing.lib_kernel.model.LoginUserBean;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;

public class LoginActiviy extends AppCompatActivity {

    @BindView(R.id.user)
    EditText user;
    @BindView(R.id.passWord)
    EditText passWord;
    @BindView(R.id.login)
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trian_activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login)
    public void onViewClicked() {

        String strUser = user.getText().toString().trim();
        String strPassWord = passWord.getText().toString().trim();

        String url = "customer/action/app/noauth/login";
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("login_name", strUser);
        map.put("login_pwd", strPassWord);
        RxRestClient.create()
                .url(url)
                .params(map)
                .build()
                .postQuery()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
                            SharedPreferenceUtils.saveisLoginPerference(LoginActiviy.this, "yes");
                            LoginUserBean.UserBean userBean = loginUserBean.getUser();
                            SharedPreferenceUtils.savePreference(LoginActiviy.this, "Token", "token", loginUserBean.getToken());
                            SharedPreferenceUtils.saveUserIDPerference(LoginActiviy.this, userBean.getId() + "");
                            SharedPreferenceUtils.saveUserNamePreference(LoginActiviy.this, userBean.getNick());
                            SharedPreferenceUtils.saveHeadPreference(LoginActiviy.this, userBean.getHead());
                            SharedPreferenceUtils.savePhonePreference(LoginActiviy.this, userBean.getLogin_phone());
                            SharedPreferenceUtils.savepaymentAccountIdPerference(LoginActiviy.this, userBean.getPaymentAccountId());
                            SharedPreferenceUtils.saveRealNamePreference(LoginActiviy.this, userBean.getReal_name());
                            SharedPreferenceUtils.saveLoginNamePreference(LoginActiviy.this, userBean.getLogin_name());
                            SharedPreferenceUtils.saveUserSex(LoginActiviy.this, userBean.getSex());

                            Intent intent = new Intent(LoginActiviy.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            SharedPreferenceUtils.saveisLoginPerference(LoginActiviy.this, "no");
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
