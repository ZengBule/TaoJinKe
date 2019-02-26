package taojinke.qianxing.task.dagger.activity;

import dagger.Component;
import taojinke.qianxing.lib_base.dagger.ActivityScope;
import taojinke.qianxing.task.base.DaggerActivity;
import taojinke.qianxing.task.dagger.activity.module.ActivityModule;
import taojinke.qianxing.task.dagger.activity.module.ActivityPresenterModule;
import taojinke.qianxing.task.dagger.application.ApplicationComponent;

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, ActivityPresenterModule.class})
public interface ActivityComponent extends ActivityComponentInjects, ActivityModule.Exposes {

    final class Initalizer {
        static public ActivityComponent init(final DaggerActivity daggerActivity, final ApplicationComponent applicationComponent) {

            return DaggerActivityComponent.builder()
                    .applicationComponent(applicationComponent)
                    .activityPresenterModule(new ActivityPresenterModule(daggerActivity))
                    .activityModule(new ActivityModule(daggerActivity))
                    .build();

        }
    }
}
