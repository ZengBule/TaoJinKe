package qianxing.taojinke.ui.user.forgetpassword;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import qianxing.taojinke.R;
import qianxing.taojinke.base.DaggerActivity;
import qianxing.taojinke.dagger.activity.ActivityComponent;
import qianxing.taojinke.modle.JumpKey;
import qianxing.taojinke.ui.user.verifycode.VerifyCodeActivity;
import taojinke.qianxing.core.OtherUtil;
import taojinke.qianxing.lib_weight.ContentWithSpaceEditText;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.user.forgetpassword
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/18+15:19
 * 修改人：
 * 修改时间：2019/2/18+15:19
 * 修改备注：
 * ***********************************************
 */
public class ForgetPasswordActivity extends DaggerActivity implements ForgetPasswordContract.IForgetPasswordView {
    @Inject
    ForgetPasswordContract.IForgetPasswordPresenter mPresenter;
    @BindView(R.id.tv_next)
    TextView tvNext;
    @BindView(R.id.tv_guide)
    TextView tvGuide;
    @BindView(R.id.et_phone_number)
    ContentWithSpaceEditText etPhoneNumber;

    private String key;

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
        key = getIntent().getStringExtra("key");
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_forget_password;
    }


    @OnClick(R.id.ll_back)
    public void onLlBackClicked() {
        finish();
    }

    @OnClick(R.id.tv_next)
    public void onTvNextClicked() {
        onNext();
    }


    private void onNext() {
        String phone = etPhoneNumber.getText().toString().replaceAll(" ", "");
        if (JumpKey.REGISTER_USER_KEY.equals(key)) {
            regNext(phone);
        } else if (JumpKey.UPDATE_BIND_PHONE_KEY.equals(key)) {
            updateBindPhoneNext(phone);
        } else if (JumpKey.FORGET_PASSWORD_KEY.equals(key)) {
            forgetPwdNext(phone);
        }

    }

    private void updateBindPhoneNext(final String phone) {
        if (phone == null || "".equals(phone)) {
            showToast("请先输入手机号");
            return;
        }
        if (!OtherUtil.isMobileNO(phone)) {
            showToast("请输入正确的手机号");
            return;
        }
        //注意此时的key发生了改变
        goToVerifyCodeImgActivity(phone, JumpKey.BIND_NEW_PHONE_KEY);

    }

    private void regNext(final String phone) {

        if (phone == null || "".equals(phone)) {
            showToast("请先输入手机号");
            return;
        }
        if (OtherUtil.isMobileNO(phone)) {
            showToast("请输入正确的手机号");
            return;
        }
        goToVerifyCodeImgActivity(phone, JumpKey.REGISTER_USER_KEY);
    }

    private void forgetPwdNext(final String phone) {
        if (phone == null || "".equals(phone)) {
            showToast("请先输入手机号");
            return;
        }
        if (!OtherUtil.isMobileNO(phone)) {
            showToast("请输入正确的手机号");
            return;
        }
        goToVerifyCodeImgActivity(phone, JumpKey.FORGET_PASSWORD_KEY);
    }

    private void goToVerifyCodeImgActivity(String phone, String key) {
        Intent intent = new Intent(this, VerifyCodeActivity.class);
        intent.putExtra("phone_number", phone);
        intent.putExtra("key", key);
        intent.putExtra("isSendSuc", true);
        startActivity(intent);
        finish();
    }
}
