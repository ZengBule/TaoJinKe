package taojinke.qianxing.lib_base.app;


import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;

import taojinke.qianxing.lib_base.app.dagger.component.GlobalComponent;

public interface ApplicationLike extends IProvider {

    void onCreate(LifecycleApplication application, GlobalComponent component);

    void onTerminate();

    void onLowMemory();

    void onTrimMemory(int level);

    void attachBaseContext(Context base);

    LifecycleApplication getApplication();

    GlobalComponent getGlobalComponent();

    default void init(Context context) {
    }
}
