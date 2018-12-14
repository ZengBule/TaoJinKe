package qianxing.taojinke.dagger.activity.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import qianxing.taojinke.base.DaggerActivity;
import taojinke.qianxing.lib_base.dagger.ActivityScope;

@Module
public class ActivityModule {

    private final DaggerActivity daggerActivity;

    public ActivityModule(final DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    @Provides
    @ActivityScope
    Context provideActivityContext() {
        return daggerActivity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return daggerActivity;
    }

    private DaggerActivity getDaggerActivity() {
        return daggerActivity;
    }


    @Provides
    @ActivityScope
    qianxing.taojinke.ui.HomeContract.IHomeView providerHomeView() {
        return (qianxing.taojinke.ui.HomeContract.IHomeView) getDaggerActivity();
    }

    @Provides
    @ActivityScope
    qianxing.taojinke.ui.main.MainContract.IMainView providerMainView() {
        return (qianxing.taojinke.ui.main.MainContract.IMainView) getDaggerActivity();
    }
}
