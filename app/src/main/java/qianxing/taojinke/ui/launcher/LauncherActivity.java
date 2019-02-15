package qianxing.taojinke.ui.launcher;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import qianxing.taojinke.R;
import qianxing.taojinke.base.DaggerActivity;
import qianxing.taojinke.dagger.activity.ActivityComponent;
import qianxing.taojinke.ui.guide.GuideActivity;
import qianxing.taojinke.ui.login.LoginActivity;
import qianxing.taojinke.ui.main.MainActivity;
import taojinke.qianxing.core.PermissionSetting;
import taojinke.qianxing.lib_kernel.logtofile.LogToFile;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.launcher
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2019/1/14+10:23
 * 修改人：
 * 修改时间：2019/1/14+10:23
 * 修改备注：
 *
 * @author 曾小浪[PHONE：18613223863]
 * ***********************************************
 */
public class LauncherActivity extends DaggerActivity implements LauncherContract.ILauncherView {
    @Inject
    LauncherContract.ILauncherPresenter mPresenter;
    /**
     * 权限设置
     */
    private PermissionSetting mSetting;

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_launcher;
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
        mSetting = new PermissionSetting(this);
        nextWithPermission();
    }

    private void nextWithPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            AndPermission.with(this).permission(
                    Permission.READ_PHONE_STATE,
                    Permission.READ_EXTERNAL_STORAGE,
                    Permission.WRITE_EXTERNAL_STORAGE,
                    Permission.RECORD_AUDIO)
                    .rationale(new DefaultRationale())
                    .onGranted(permissions -> mPresenter.getAppVersionInfo())
                    .onDenied(permissions -> {
                        if (AndPermission.hasAlwaysDeniedPermission(LauncherActivity.this, permissions)) {
                            mSetting.showSetting(permissions);
                        }
                    })
                    .start();
        } else {
            mPresenter.getAppVersionInfo();
        }
    }

    @Override
    public void checkTokenCallback(String content) {

        String vd = SharedPreferenceUtils.getVersionIDPreference(this);
        isFirstIn = vd == null || "".equals(vd);
        UIHandler handler = new UIHandler(this);
        if (TextUtils.isEmpty(content)) {
            isLogined = false;
            handler.sendEmptyMessage(1000);
        } else {
            CheckTokenInfo info = JSON.parseObject(content, CheckTokenInfo.class);
            LogToFile.d("CheckLogin", "CheckLogin111 message = " + info.getMessage() + ";result = " + info.getData());
            if (TextUtils.isEmpty(info.getMessage()) || TextUtils.equals("成功", info.getMessage())) {
                isLogined = true;
            } else if (info.getData() instanceof Integer) {
                if (TextUtils.equals("201", String.valueOf(info.getData()))) {
                    isLogined = false;
                }
            }
            handler.sendEmptyMessage(1000);
        }

    }

    private boolean isFirstIn = true;
    private boolean isLogined = false;

    @SuppressLint("HandlerLeak")
    private class UIHandler extends Handler {

        WeakReference<LauncherActivity> weakReference;

        UIHandler(LauncherActivity activity) {
            this.weakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LauncherActivity activity = weakReference.get();
            switch (msg.what) {
                case 1000:
                    if (isFirstIn) {
                        Intent intent = new Intent(activity, GuideActivity.class);
                        startActivity(intent);
                    } else {
                        if (isLogined) {
                            Intent intent = getIntent();
                            String content = intent.toUri(Intent.URI_INTENT_SCHEME);
                            Intent mainIntent = new Intent(activity, MainActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("pushContent", content);
                            mainIntent.putExtras(bundle);
                            startActivity(mainIntent);
                        } else {
                            Intent intent = new Intent(activity, LoginActivity.class);
                            intent.putExtra("from_which_activity", "LoadingActivity");
                            startActivity(intent);
                        }
                    }
                    break;

                default:
                    break;
            }
        }
    }
}
