package taojinke.qianxing.chat.dagger.activity.module;

import dagger.Module;
import taojinke.qianxing.chat.base.DaggerActivity;
import taojinke.qianxing.chat.dagger.activity.ActivityComponent;

@Module
public class ActivityPresenterModule {
    private final DaggerActivity daggerActivity;

    public ActivityPresenterModule(DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    public ActivityComponent getActivityComponent() {
        return daggerActivity.getActivityComponent();
    }

}
