package taojinke.qianxing.earlywarning.app;

import android.content.Context;

import taojinke.qianxing.earlywarning.dagger.ComponentFactory;
import taojinke.qianxing.earlywarning.dagger.application.ApplicationComponent;
import taojinke.qianxing.lib_base.app.ApplicationLike;
import taojinke.qianxing.lib_base.app.LifecycleApplication;
import taojinke.qianxing.lib_base.app.dagger.component.GlobalComponent;

/**
 * ***********************************************
 * 包路径：taojinke.qianxing.mine.app
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2018/12/18+14:06
 * 修改人：
 * 修改时间：2018/12/18+14:06
 * 修改备注：
 * ***********************************************
 */

public class TaskApplicationLikeImpl implements ApplicationLike {
    private LifecycleApplication application;
    private GlobalComponent globalComponent;
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate(LifecycleApplication application, GlobalComponent component) {
        this.application = application;
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
        return application;
    }

    @Override
    public GlobalComponent getGlobalComponent() {
        return globalComponent;
    }

    @Override
    public void init(Context context) {

    }
}
