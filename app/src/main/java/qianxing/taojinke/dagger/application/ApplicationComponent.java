package qianxing.taojinke.dagger.application;

import dagger.Component;
import qianxing.taojinke.TaoJinKeApplicationLike;
import qianxing.taojinke.dagger.application.module.ApplicationLikeModule;
import taojinke.qianxing.lib_base.app.dagger.component.GlobalComponent;
import taojinke.qianxing.lib_base.dagger.ModuleSingleton;

@ModuleSingleton
@Component(modules = ApplicationLikeModule.class, dependencies = GlobalComponent.class)
public interface ApplicationComponent extends ApplicationComponentInjects {
    final class Initializer {
        public Initializer() {
        }

        static public ApplicationComponent init(final TaoJinKeApplicationLike applicationLike) {

            return DaggerApplicationComponent.builder()
                    .globalComponent(applicationLike.getGlobalComponent())
                    .applicationLikeModule(new ApplicationLikeModule(applicationLike))
                    .build();
        }
    }
}
