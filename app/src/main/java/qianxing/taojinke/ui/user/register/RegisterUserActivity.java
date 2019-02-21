package qianxing.taojinke.ui.user.register;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.BigDecimal;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import qianxing.taojinke.R;
import qianxing.taojinke.base.DaggerActivity;
import qianxing.taojinke.dagger.activity.ActivityComponent;
import qianxing.taojinke.ui.user.verifycode.VerifyCodeActivity;
import taojinke.qianxing.core.KeyBoardUtils;
import taojinke.qianxing.lib_weight.ContentWithSpaceEditText;


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
public class RegisterUserActivity extends DaggerActivity implements RegisterUserContract.IRegisterUserView {
    @Inject
    RegisterUserContract.IRegisterUserPresenter mPresenter;
    @BindView(R.id.tv_phone_number)
    ContentWithSpaceEditText tvPhoneNumber;

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_register_user;
    }

    @Override
    protected void onPause() {
        KeyBoardUtils.hideSoftInput(this, tvPhoneNumber);
        super.onPause();
    }

    @OnClick(R.id.ll_back)
    public void onLlBackClicked() {
        finish();
    }

    @OnClick(R.id.tv_next_step)
    public void onTvNextStepClicked() {

        if (tvPhoneNumber.getText() != null) {
            if (tvPhoneNumber.getText().toString().isEmpty()) {
                showToast("请输入正确的电话号码！");
                return;
            }
            String phoneNumber = tvPhoneNumber.getText().toString().replaceAll(" ", "");
            //只判断电话号码是否是数字
            if (TextUtils.isEmpty(phoneNumber) || !isNum(phoneNumber)) {
                showToast("请输入正确的电话号码！");
                return;
            }
            String deviceId = getUniqueId(this);
            mPresenter.sendRegisterSMS(deviceId, phoneNumber);
        }

    }

    public String getUniqueId(Context context) {
        String androidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return androidID + Build.SERIAL;
    }

    public boolean isNum(String str) {
        try {
            new BigDecimal(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void goToIdentifyCodeActivity(String phoneNumber) {
        Bundle bundle = new Bundle();
        bundle.putString("phone_number", phoneNumber);
        lanuchActivity(VerifyCodeActivity.class, bundle);
    }
}
