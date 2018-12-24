package taojinke.qianxing.train.dagger.activity;


import dagger.Component;
import taojinke.qianxing.lib_base.dagger.ActivityScope;
import taojinke.qianxing.train.base.DaggerActivity;
import taojinke.qianxing.train.dagger.activity.module.ActivityModule;
import taojinke.qianxing.train.dagger.activity.module.ActivityPresenterModule;
import taojinke.qianxing.train.dagger.application.TrainApplicationComponent;

@ActivityScope
@Component(dependencies = TrainApplicationComponent.class, modules = {ActivityModule.class, ActivityPresenterModule.class})
public interface ActivityComponent extends ActivityComponentInjects, ActivityModule.Exposes {

    final class Initalizer {
        static public ActivityComponent init(final DaggerActivity daggerActivity, final TrainApplicationComponent applicationComponent) {

            return DaggerActivityComponent.builder()
                    .trainApplicationComponent(applicationComponent)
                    .activityPresenterModule(new ActivityPresenterModule(daggerActivity))
                    .activityModule(new ActivityModule(daggerActivity))
                    .build();

        }
    }
}
