package qianxing.taojinke.ui.launcher;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import taojinke.qianxing.core.VersionUtils;
import taojinke.qianxing.lib_kernel.http.net.rx.RxRestClient;
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
 * ***********************************************
 */
public class LauncherPresenter implements LauncherContract.ILauncherPresenter {
    @Inject
    LauncherContract.ILauncherView mView;


    @Override
    public void getAppVersionInfo() {
        String url = "customer/action/app/noauth/version";
        HashMap<String, Object> map = new HashMap<>(1);
        map.put("appType", "0");
        RxRestClient.create()
                .url(url)
                .params(map)
                .build()
                .post()
                .subscribeOn(Schedulers.io())
                .compose(mView.bindLifecycleAndThreadWithLoading())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {


                        VersionInfo versionInfo = JSON.parseObject(s, VersionInfo.class);
                        if (TextUtils.equals(versionInfo.getMessage(), "成功") && versionInfo.getData() != null) {
                            String versionName = VersionUtils.getVersionName(mView.fetchContext());
                            if (compareVersion(versionInfo.getData().getVersion(), versionName) != 1) {
                                checkTokenIsOk();
                            } else if (compareVersion(versionInfo.getData().getVersion(), versionName) == 1) {

                            }
                        } else {
                            if (TextUtils.isEmpty(versionInfo.getMessage())) {
                                mView.showToast("请求更新失败");
                            } else {
                                mView.showToast(versionInfo.getMessage());
                            }
                            checkTokenIsOk();
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

    /**
     * 版本号比较
     *
     * @param version1 ver
     * @param version2 ver
     * @return 0代表相等，1代表version1大于version2，-1代表version1小于version2
     */
    private int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int index = 0;
        // 获取最小长度值
        int minLen = Math.min(version1Array.length, version2Array.length);
        int diff = 0;
        // 循环判断每位的大小
        while (index < minLen
                && (diff = Integer.parseInt(version1Array[index])
                - Integer.parseInt(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            // 如果位数不一致，比较多余位数
            for (int i = index; i < version1Array.length; i++) {
                if (Integer.parseInt(version1Array[i]) > 0) {
                    return 1;
                }
            }
            for (int i = index; i < version2Array.length; i++) {
                if (Integer.parseInt(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

    /**
     * 检查token是否过期
     */
    private void checkTokenIsOk() {
        String token = SharedPreferenceUtils.getPreference("Token", "token", mView.fetchContext());
        if (TextUtils.isEmpty(token) || TextUtils.equals("null", token)) {
            mView.checkTokenCallback("");
            return;
        }
        String url = "customer/action/app/checkLogin";
        HashMap<String, Object> map = new HashMap<>(1);
        map.put("appType", "0");
        RxRestClient.create()
                .url(url)
                .params(map)
                .build()
                .post()
                .subscribeOn(Schedulers.io())
                .compose(mView.bindLifecycleAndThreadWithLoading())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String s) {
                        mView.checkTokenCallback(s);

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
