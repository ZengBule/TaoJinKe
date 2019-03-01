package taojinke.qianxing.earlywarning.dagger.activity.module;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.FragmentManager;
import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.earlywarning.base.DaggerActivity;
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
    taojinke.qianxing.earlywarning.ui.TaskEcecuterContract.ITaskEcecuterView providerTaskEcecuterView() {
        return (taojinke.qianxing.earlywarning.ui.TaskEcecuterContract.ITaskEcecuterView) getDaggerActivity();
    }

    @Provides
    @ActivityScope
    taojinke.qianxing.earlywarning.ui.clazz.TaskWaitCompletContract.ITaskWaitCompletView providerTaskWaitCompletView() {
        return (taojinke.qianxing.earlywarning.ui.clazz.TaskWaitCompletContract.ITaskWaitCompletView) getDaggerActivity();
    }

    @Provides
    @ActivityScope
    taojinke.qianxing.earlywarning.ui.alarm.AlarmContract.IAlarmView providerAlarmView() {
        return (taojinke.qianxing.earlywarning.ui.alarm.AlarmContract.IAlarmView) getDaggerActivity();
    }

    @Provides
    @ActivityScope
    taojinke.qianxing.earlywarning.ui.rule.AlarmRulerAndSpeackContract.IAlarmRulerAndSpeackView providerAlarmRulerAndSpeackView() {
        return (taojinke.qianxing.earlywarning.ui.rule.AlarmRulerAndSpeackContract.IAlarmRulerAndSpeackView) getDaggerActivity();
    }


    public interface Exposes {

        Activity activity();

        Context context();

        FragmentManager fragmentManager();
    }
}
