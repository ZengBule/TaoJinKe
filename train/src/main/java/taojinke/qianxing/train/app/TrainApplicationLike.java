package taojinke.qianxing.train.app;

import android.content.Context;

import taojinke.qianxing.lib_base.app.ApplicationLike;
import taojinke.qianxing.lib_base.app.LifecycleApplication;
import taojinke.qianxing.lib_base.app.dagger.component.GlobalComponent;
import taojinke.qianxing.train.dagger.ComponentFactory;
import taojinke.qianxing.train.dagger.application.TrainApplicationComponent;

public class TrainApplicationLike implements ApplicationLike {

    private LifecycleApplication lifecycleApplication;
    private GlobalComponent globalComponent;
    private TrainApplicationComponent trainApplicationComponent;

    @Override
    public void onCreate(LifecycleApplication application, GlobalComponent component) {
        this.lifecycleApplication = application;
        this.globalComponent = component;
    }

    public TrainApplicationComponent getApplicationComponent() {
        if (trainApplicationComponent == null) {
            trainApplicationComponent = ComponentFactory.createApplicationComponent(this);
            trainApplicationComponent.inject(this);
        }
        return trainApplicationComponent;
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
