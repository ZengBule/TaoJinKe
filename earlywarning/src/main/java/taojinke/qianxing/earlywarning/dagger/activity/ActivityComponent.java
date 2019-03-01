package taojinke.qianxing.earlywarning.dagger.activity;

import dagger.Component;
import taojinke.qianxing.earlywarning.base.DaggerActivity;
import taojinke.qianxing.earlywarning.dagger.activity.module.ActivityModule;
import taojinke.qianxing.earlywarning.dagger.activity.module.ActivityPresenterModule;
import taojinke.qianxing.earlywarning.dagger.application.ApplicationComponent;
import taojinke.qianxing.lib_base.dagger.ActivityScope;

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
