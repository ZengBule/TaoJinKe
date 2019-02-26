package taojinke.qianxing.task.dagger.application;

import dagger.Component;
import taojinke.qianxing.lib_base.app.dagger.component.GlobalComponent;
import taojinke.qianxing.lib_base.dagger.ModuleSingleton;
import taojinke.qianxing.task.app.TaskApplicationLikeImpl;
import taojinke.qianxing.task.dagger.application.module.ApplicationLikeModule;

@ModuleSingleton
@Component(modules = ApplicationLikeModule.class, dependencies = GlobalComponent.class)
public interface ApplicationComponent extends ApplicationComponentExpoes, ApplicationComponentInjects {
    final class Initializer {
        public Initializer() {

        }

        static public ApplicationComponent init(final TaskApplicationLikeImpl applicationLike) {

            return DaggerApplicationComponent.builder()
                    .globalComponent(applicationLike.getGlobalComponent())
                    .applicationLikeModule(new ApplicationLikeModule(applicationLike))
                    .build();
        }
    }
}
