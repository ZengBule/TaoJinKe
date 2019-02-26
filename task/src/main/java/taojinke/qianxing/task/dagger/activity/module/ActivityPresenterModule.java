package taojinke.qianxing.task.dagger.activity.module;

import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.lib_base.dagger.ActivityScope;
import taojinke.qianxing.task.base.DaggerActivity;
import taojinke.qianxing.task.dagger.activity.ActivityComponent;

@Module
public class ActivityPresenterModule {
    private final DaggerActivity daggerActivity;

    public ActivityPresenterModule(DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    public ActivityComponent getActivityComponent() {
        return daggerActivity.getActivityComponent();
    }

    @Provides
    @ActivityScope
    taojinke.qianxing.task.ui.status.TaskExecutingContract.ITaskExecutingPresenter providerTaskExecutingPresenter() {
        taojinke.qianxing.task.ui.status.TaskExecutingPresenter presenter = new taojinke.qianxing.task.ui.status.TaskExecutingPresenter();
        getActivityComponent().inject(presenter);
        return presenter;
    }
}
