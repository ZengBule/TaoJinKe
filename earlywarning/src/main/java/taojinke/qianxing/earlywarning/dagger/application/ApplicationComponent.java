package taojinke.qianxing.earlywarning.dagger.application;

import dagger.Component;
import taojinke.qianxing.earlywarning.app.TaskApplicationLikeImpl;
import taojinke.qianxing.earlywarning.dagger.application.module.ApplicationLikeModule;
import taojinke.qianxing.lib_base.app.dagger.component.GlobalComponent;
import taojinke.qianxing.lib_base.dagger.ModuleSingleton;

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
