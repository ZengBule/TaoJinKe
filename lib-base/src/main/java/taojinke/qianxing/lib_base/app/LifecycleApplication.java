package taojinke.qianxing.lib_base.app;


import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.HashMap;
import java.util.Map;

import taojinke.qianxing.lib_base.app.dagger.component.DaggerGlobalComponent;
import taojinke.qianxing.lib_base.app.dagger.component.GlobalComponent;
import taojinke.qianxing.lib_base.app.dagger.module.ApplicationModule;
import taojinke.qianxing.lib_weight.loading.DefaultStatusViewCreator;
import taojinke.qianxing.lib_weight.loading.LoadingHelperViewCreator;

public class LifecycleApplication extends Application {

    private GlobalComponent globalComponent;
    private Map<String, ApplicationLike> lifecycleMap = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();
        LoadingHelperViewCreator.setDefaultStatusViewCreator(new DefaultStatusViewCreator());
        ARouter.openLog();
        //线上需关闭 调试时可用，否则不能使用Instant run
        ARouter.openDebug();
        ARouter.init(this);

        globalComponent = DaggerGlobalComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        registerCallbacks(getActivityLifecycleCallbacks());

    }

    private void registerCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }


    protected ActivityLifecycleCallbacks getActivityLifecycleCallbacks() {
        return new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                ActivityManager.getInstance().push(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                ActivityManager.getInstance().remove(activity);
            }
        };
    }

    public GlobalComponent getGlobalComponent() {
        return globalComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
