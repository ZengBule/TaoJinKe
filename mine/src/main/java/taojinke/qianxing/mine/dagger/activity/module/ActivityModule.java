package taojinke.qianxing.mine.dagger.activity.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.lib_base.dagger.ActivityScope;
import taojinke.qianxing.mine.base.DaggerActivity;
import taojinke.qianxing.mine.ui.main.MainContract;

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
    MainContract.IMainView providerMainView() {
        return (MainContract.IMainView) getDaggerActivity();
    }


    public interface Exposes {

        Activity activity();

        Context context();

        FragmentManager fragmentManager();
    }
}
