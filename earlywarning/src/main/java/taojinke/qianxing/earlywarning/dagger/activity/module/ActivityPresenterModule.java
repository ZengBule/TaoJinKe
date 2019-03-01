package taojinke.qianxing.earlywarning.dagger.activity.module;

import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.earlywarning.base.DaggerActivity;
import taojinke.qianxing.earlywarning.dagger.activity.ActivityComponent;
import taojinke.qianxing.lib_base.dagger.ActivityScope;

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
    taojinke.qianxing.earlywarning.ui.TaskEcecuterContract.ITaskEcecuterPresenter providerTaskEcecuterPresenter() {
        taojinke.qianxing.earlywarning.ui.TaskEcecuterPresenter presenter = new taojinke.qianxing.earlywarning.ui.TaskEcecuterPresenter();
        getActivityComponent().inject(presenter);
        return presenter;
    }

    @Provides
    @ActivityScope
    taojinke.qianxing.earlywarning.ui.clazz.TaskWaitCompletContract.ITaskWaitCompletPresenter providerTaskWaitCompletPresenter() {
        taojinke.qianxing.earlywarning.ui.clazz.TaskWaitCompletPresenter presenter = new taojinke.qianxing.earlywarning.ui.clazz.TaskWaitCompletPresenter();
        getActivityComponent().inject(presenter);
        return presenter;
    }

    @Provides
    @ActivityScope
    taojinke.qianxing.earlywarning.ui.alarm.AlarmContract.IAlarmPresenter providerAlarmPresenter() {
        taojinke.qianxing.earlywarning.ui.alarm.AlarmPresenter presenter = new taojinke.qianxing.earlywarning.ui.alarm.AlarmPresenter();
        getActivityComponent().inject(presenter);
        return presenter;
    }

    @Provides
    @ActivityScope
    taojinke.qianxing.earlywarning.ui.rule.AlarmRulerAndSpeackContract.IAlarmRulerAndSpeackPresenter providerAlarmRulerAndSpeackPresenter() {
        taojinke.qianxing.earlywarning.ui.rule.AlarmRulerAndSpeackPresenter presenter = new taojinke.qianxing.earlywarning.ui.rule.AlarmRulerAndSpeackPresenter();
        getActivityComponent().inject(presenter);
        return presenter;
    }
}
