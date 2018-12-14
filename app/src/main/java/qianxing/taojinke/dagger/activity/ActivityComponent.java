package qianxing.taojinke.dagger.activity;

import dagger.Component;
import qianxing.taojinke.base.DaggerActivity;
import qianxing.taojinke.dagger.activity.module.ActivityModule;
import qianxing.taojinke.dagger.activity.module.ActivityPresenterModule;
import qianxing.taojinke.dagger.application.ApplicationComponent;
import taojinke.qianxing.lib_base.dagger.ActivityScope;

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, ActivityPresenterModule.class})
public interface ActivityComponent extends ActivityComponentInjects {

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
