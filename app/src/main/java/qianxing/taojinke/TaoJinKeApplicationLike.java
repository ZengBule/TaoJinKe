package qianxing.taojinke;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

import qianxing.taojinke.dagger.ComponentFactory;
import qianxing.taojinke.dagger.application.ApplicationComponent;
import taojinke.qianxing.lib_base.app.ApplicationLike;
import taojinke.qianxing.lib_base.app.LifecycleApplication;
import taojinke.qianxing.lib_base.app.dagger.component.GlobalComponent;

/**
 * ***********************************************
 * 包路径：
 * 类描述:模块对应的application
 * 创建人：Zengxialang[PHONE：18613223863]
 * 创建时间：2018/12/13
 * 修改人：
 * 修改时间：2018/12/13
 * 修改备注：
 * ***********************************************
 */
public class TaoJinKeApplicationLike implements ApplicationLike {

    private LifecycleApplication lifecycleApplication;
    private GlobalComponent globalComponent;
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate(LifecycleApplication application, GlobalComponent component) {
        this.lifecycleApplication = application;
        this.globalComponent = component;
    }

    public ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            applicationComponent = ComponentFactory.createApplicationComponent(this);
            applicationComponent.inject(this);
        }
        return applicationComponent;
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }

    @Override
    public void attachBaseContext(Context base) {

    }

    @Override
    public LifecycleApplication getApplication() {
        return lifecycleApplication;
    }

    @Override
    public GlobalComponent getGlobalComponent() {
        return globalComponent;
    }

    @Override
    public void init(Context context) {

    }
}
