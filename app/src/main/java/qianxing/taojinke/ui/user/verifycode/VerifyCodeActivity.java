package qianxing.taojinke.ui.user.verifycode;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import qianxing.taojinke.R;
import qianxing.taojinke.base.DaggerActivity;
import qianxing.taojinke.dagger.activity.ActivityComponent;
import qianxing.taojinke.modle.JumpKey;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;
import taojinke.qianxing.lib_weight.PwdEditText1;


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
public class VerifyCodeActivity extends DaggerActivity implements VerifyCodeContract.IVerifyCodeView {
    @Inject
    VerifyCodeContract.IVerifyCodePresenter mPresenter;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_next)
    TextView tvNext;
    @BindView(R.id.tv_guide)
    TextView tvGuide;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.et_yzm)
    PwdEditText1 etYzm;
    @BindView(R.id.ll_content)
    LinearLayout llContent;

    private String vCode;
    private String phone;
    //判断页面跳转逻辑
    private String key;
    private boolean isSendSuc;
    private SpannableString spanStr;

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
        phone = getIntent().getStringExtra("phone_number");
        key = getIntent().getStringExtra("key");
        vCode = getIntent().getStringExtra("verifyCode");
        isSendSuc = getIntent().getBooleanExtra("isSendSuc", false);

        initView();
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_verify_code;
    }

    @Override
    protected void onResume() {
        super.onResume();
        showOrHideKb();
    }

    public void showOrHideKb() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void initView() {

        if (JumpKey.UPDATE_BIND_PHONE_KEY.equals(key)) {
            tvGuide.setText("修改登录手机");
        } else if (JumpKey.UPDATE_LOGIN_PASSWORD_KEY.equals(key)) {
            tvGuide.setText("修改登录密码");
        } else if (JumpKey.UPDATE_PAY_PASSWORD_KEY.equals(key)) {
            tvGuide.setText("设置提密码");
        }

        spanStr = new SpannableString("验证码已失效，点击重新发送");
        spanStr.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.RED);
                ds.setUnderlineText(true);
            }
        }, spanStr.length() - 4, spanStr.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        tvTime.setHighlightColor(Color.TRANSPARENT);
        if (!TextUtils.isEmpty(phone) && phone.length() > 10) {
            tvPhone.setText("短信验证码已发送至手机" + phone.substring(0, 3) + "****" + phone.substring(7, 11));
        }
        etYzm.setOnInputFinishListener(new PwdEditText1.OnInputFinishListener() {
            @Override
            public void onInputFinish(String password) {
                onNext(password);
            }
        });

    }

    @OnClick(R.id.ll_back)
    public void onLlBackClicked() {
        finish();
    }

    @OnClick(R.id.tv_next)
    public void onTvNextClicked() {

        String code = etYzm.getText().toString();
        onNext(code);
    }

    private void onNext(final String code) {

        if (code == null || "".equals(code)) {
            showToast("请先输入验证码");
            return;
        }
        if (JumpKey.REGISTER_USER_KEY.equals(key)) {
            mPresenter.keyRegisterUser(phone, code);
        } else if (JumpKey.FORGET_PASSWORD_KEY.equals(key)) {
//            Intent intent = new Intent(InputIcActivity.this, InputPwdActivity.class);
//            intent.putExtra("code", code);
//            intent.putExtra("phone_number", phone);
//            intent.putExtra("key", key);
//            startActivity(intent);
//            finish();

        } else if (JumpKey.UPDATE_BIND_PHONE_KEY.equals(key)) {
            mPresenter.keyUpdateBindPhone(code);
        } else if (JumpKey.BIND_NEW_PHONE_KEY.equals(key)) {
            mPresenter.keyBindNewPhone(phone, code);
        } else if (JumpKey.UPDATE_LOGIN_PASSWORD_KEY.equals(key)) {
            mPresenter.keyUpdateLoginPassword(phone, code);
        } else if (JumpKey.UPDATE_PAY_PASSWORD_KEY.equals(key)) {
//            Intent intent = new Intent(InputIcActivity.this, InputPwdActivity.class);
//            intent.putExtra("code", code);
//            intent.putExtra("phone_number", phone);
//            intent.putExtra("key", JumpKey.UPDATE_PAY_PASSWORD_KEY);
//            startActivity(intent);
//            finish();
        } else if (JumpKey.MODIFY_FORWARD_PASSWORD_KEY.equals(key)) {
//            HashMap<String, Object> modifyPasMap = new HashMap<>();
//            modifyPasMap.put("type", SET_PASSWORD_TYPE);
//            modifyPasMap.put("activity", "reset_forward_password");
//            modifyPasMap.put("smsCode", code);
//            ActivitySkipUtil.skipAnotherActivity(modifyPasMap, this, WalletPasswordActivity.class);
//            finish();
        } else if (JumpKey.RESET_LOGIN_PASSWORD_KEY.equals(key)) {
//            HashMap<String, Object> modifyLoginPasMap = new HashMap<>();
//            modifyLoginPasMap.put("type", SET_PASSWORD_TYPE);
//            modifyLoginPasMap.put("activity", "reset_login_password");
//            modifyLoginPasMap.put("smsCode", code);
//            ActivitySkipUtil.skipAnotherActivity(modifyLoginPasMap, this, WalletPasswordActivity.class);
//            finish();
        }

    }


}
