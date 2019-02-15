package qianxing.taojinke.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import qianxing.taojinke.R;
import qianxing.taojinke.base.DaggerActivity;
import qianxing.taojinke.dagger.activity.ActivityComponent;
import qianxing.taojinke.ui.test.TestSettingActivity;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;
import taojinke.qianxing.lib_weight.ContentWithSpaceEditText;


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
public class LoginActivity extends DaggerActivity implements LoginContract.ILoginView {
    @Inject
    LoginContract.ILoginPresenter mPresenter;
    @BindView(R.id.ed_login_account)
    ContentWithSpaceEditText edLoginAccount;
    @BindView(R.id.ll_login_account)
    LinearLayout llLoginAccount;
    @BindView(R.id.ed_login_password)
    EditText edLoginPassword;
    @BindView(R.id.iv_login_delete)
    ImageView ivLoginDelete;
    @BindView(R.id.iv_login_show)
    ImageView ivLoginShow;
    @BindView(R.id.iv_login_test)
    ImageView ivLoginTest;
    @BindView(R.id.ll_login_password)
    LinearLayout llLoginPassword;
    @BindView(R.id.tv_login_forget)
    TextView tvLoginForget;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.ll_login_register)
    LinearLayout llLoginRegister;
    long[] mHits = null;
    @BindView(R.id.iv_login_setting)
    ImageView ivLoginSetting;
    private boolean isShowPassWord;

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
        initEvent();
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_login;
    }


    private void initEvent() {
        edLoginAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edLoginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(edLoginPassword.getText().toString())) {
                    ivLoginDelete.setVisibility(View.GONE);
                } else {
                    ivLoginDelete.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    @OnClick({R.id.iv_login_delete, R.id.iv_login_show, R.id.tv_login_forget, R.id.tv_login, R.id.ll_login_register, R.id.iv_login_test, R.id.iv_login_setting})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.iv_login_delete:
                deleteInput();
                break;
            case R.id.iv_login_show:
                isShowPassword();
                break;
            case R.id.tv_login_forget:
                forgetPassword();
                break;
            case R.id.tv_login:
                loginTjk();
                break;
            case R.id.ll_login_register:
                registerAccount();
                break;
            case R.id.iv_login_test:
//                onDisplaySettingActivity();
                break;
            case R.id.iv_login_setting:
                onDisplaySettingActivity();
                break;
            default:
                break;
        }
    }

    /**
     * 注册账号
     */
    private void registerAccount() {
//        Intent intent = new Intent(LoginActivity.this, PhoneNumberActivity.class);
//        startActivity(intent);
    }

    /**
     * 登录功能
     */
    private void loginTjk() {

        String user = Objects.requireNonNull(edLoginAccount.getText()).toString().trim();
        String password = edLoginPassword.getText().toString().trim();
        if (TextUtils.isEmpty(user)) {
            showToast("请输入账号!");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            showToast("请输入密码!");
            return;
        }
        mPresenter.loginTjk(user.replaceAll(" ", ""), password);
    }

//    /**
//     * 保存用户数据
//     */
//    private void saveUserInfo(LoginUserBean loginUserBean) {
//        LoginUserBean.UserBean userBean = loginUserBean.getUser();
//        SharedPreferenceUtils.savePreference(this, "Token", "token", loginUserBean.getToken());
//        SharedPreferenceUtils.saveUserIDPerference(this, userBean.getId() + "");
//        SharedPreferenceUtils.saveUserNamePreference(this, userBean.getNick());
//        SharedPreferenceUtils.saveHeadPreference(this, userBean.getHead());
//        SharedPreferenceUtils.savePhonePreference(this, userBean.getLogin_phone());
//        SharedPreferenceUtils.savepaymentAccountIdPerference(this, userBean.getPaymentAccountId());
//        SharedPreferenceUtils.saveRealNamePreference(this, userBean.getReal_name());
//        SharedPreferenceUtils.saveLoginNamePreference(this, userBean.getLogin_name());
//        SharedPreferenceUtils.saveUserSex(this, userBean.getSex());
//    }

    /**
     * 忘记密码
     */
    private void forgetPassword() {

    }

    /**
     * 删除已输入的密码
     */
    private void deleteInput() {
        edLoginPassword.setText("");
    }

    /**
     * 是否显示密码
     */
    private void isShowPassword() {
        isShowPassWord = !isShowPassWord;
        if (isShowPassWord) {
            edLoginPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            ivLoginShow.setImageResource(R.mipmap.icon_login_show_password);
        } else {
            edLoginPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            ivLoginShow.setImageResource(R.mipmap.icon_login_un_show_password);
        }
    }

    private void onDisplaySettingActivity() {
        if (mHits == null) {
            mHits = new long[5];
        }
        System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);
        mHits[mHits.length - 1] = SystemClock.uptimeMillis();
        if (SystemClock.uptimeMillis() - mHits[0] < 1000) {
            mHits = null;
            startActivity(new Intent(this, TestSettingActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        SharedPreferenceUtils.clearVoipPerference(this);
        SharedPreferenceUtils.clearVoipPwdPerference(this);
        SharedPreferenceUtils.clearUserIDPerference(this);
        SharedPreferenceUtils.clearUserNamePreference(this);
        SharedPreferenceUtils.clearHeadPreference(this);
        SharedPreferenceUtils.clearPhonePreference(this);
        SharedPreferenceUtils.clearpaymentAccountIdPerference(this);
        super.onBackPressed();
    }

}
