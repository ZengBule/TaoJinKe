package taojinke.qianxing.mine.dagger.application;

import dagger.Component;
import taojinke.qianxing.lib_base.app.dagger.component.GlobalComponent;
import taojinke.qianxing.lib_base.dagger.ModuleSingleton;
import taojinke.qianxing.mine.app.MineApplicationLikeImpl;
import taojinke.qianxing.mine.dagger.application.module.ApplicationLikeModule;

@ModuleSingleton
@Component(modules = ApplicationLikeModule.class, dependencies = GlobalComponent.class)
public interface ApplicationComponent extends ApplicationComponentExpoes, ApplicationComponentInjects {
    final class Initializer {
        public Initializer() {

        }

        static public ApplicationComponent init(final MineApplicationLikeImpl applicationLike) {

            return DaggerApplicationComponent.builder()
                    .globalComponent(applicationLike.getGlobalComponent())
                    .applicationLikeModule(new ApplicationLikeModule(applicationLike))
                    .build();
        }
    }
}
