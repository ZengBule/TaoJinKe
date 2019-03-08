package taojinke.qianxing.train.dagger.activity.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.lib_base.dagger.ActivityScope;
import taojinke.qianxing.train.base.DaggerActivity;

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
    taojinke.qianxing.train.ui.main.MainContract.IMainView providerMainView() {
        return (taojinke.qianxing.train.ui.main.MainContract.IMainView) getDaggerActivity();
    }


    public interface Exposes {

        Activity activity();

        Context context();

    }
}
