package taojinke.qianxing.mine.dagger.activity.module;

import dagger.Module;
import taojinke.qianxing.mine.base.DaggerActivity;
import taojinke.qianxing.mine.dagger.activity.ActivityComponent;

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
