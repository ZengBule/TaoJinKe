package taojinke.qianxing.chat.dagger.activity.module;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.FragmentManager;
import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.chat.base.DaggerActivity;
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



    public interface Exposes {

        Activity activity();

        Context context();

        FragmentManager fragmentManager();
    }
}
