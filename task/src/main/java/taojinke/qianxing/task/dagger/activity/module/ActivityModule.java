package taojinke.qianxing.task.dagger.activity.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.lib_base.dagger.ActivityScope;
import taojinke.qianxing.task.base.DaggerActivity;

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
    taojinke.qianxing.task.ui.status.TaskExecutingContract.ITaskExecutingView providerTaskExecutingView() {
        return (taojinke.qianxing.task.ui.status.TaskExecutingContract.ITaskExecutingView) getDaggerActivity();
    }


    public interface Exposes {

        Activity activity();

        Context context();

        FragmentManager fragmentManager();
    }
}
