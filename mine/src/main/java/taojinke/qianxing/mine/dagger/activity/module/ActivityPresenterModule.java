package taojinke.qianxing.mine.dagger.activity.module;

import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.lib_base.dagger.ActivityScope;
import taojinke.qianxing.mine.base.DaggerActivity;
import taojinke.qianxing.mine.dagger.activity.ActivityComponent;
import taojinke.qianxing.mine.ui.main.MainContract;
import taojinke.qianxing.mine.ui.main.MainPresenter;

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
    MainContract.IMainPresenter providerMainPresenter() {
        MainPresenter presenter = new MainPresenter();
        getActivityComponent().inject(presenter);
        return presenter;
    }
}
