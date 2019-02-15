package qianxing.taojinke.dagger.activity.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

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

    @Provides
    @ActivityScope
    FragmentManager provideFragmentManager() {
        return daggerActivity.getSupportFragmentManager();
    }


    private DaggerActivity getDaggerActivity() {
        return daggerActivity;
    }



    @Provides
    @ActivityScope
    qianxing.taojinke.ui.main.MainContract.IMainView providerMainView() {
        return (qianxing.taojinke.ui.main.MainContract.IMainView) getDaggerActivity();
    }

    @Provides
    @ActivityScope
    qianxing.taojinke.ui.launcher.LauncherContract.ILauncherView providerLauncherView() {
        return (qianxing.taojinke.ui.launcher.LauncherContract.ILauncherView) getDaggerActivity();
    }

    @Provides
    @ActivityScope
    qianxing.taojinke.ui.login.LoginContract.ILoginView providerLoginView() {
        return (qianxing.taojinke.ui.login.LoginContract.ILoginView) getDaggerActivity();
    }

    public interface Exposes {

        Activity activity();

        Context context();

        FragmentManager fragmentManager();
    }
}
