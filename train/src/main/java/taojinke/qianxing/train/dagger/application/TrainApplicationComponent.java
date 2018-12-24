package taojinke.qianxing.train.dagger.application;

import dagger.Component;
import taojinke.qianxing.lib_base.app.dagger.component.GlobalComponent;
import taojinke.qianxing.lib_base.dagger.ModuleSingleton;
import taojinke.qianxing.train.app.TrainApplicationLike;

@ModuleSingleton
@Component(modules = TrainApplicatonModule.class, dependencies = GlobalComponent.class)
public interface TrainApplicationComponent extends TrainApplicatonModule.Exposes, TrainApplicationComponentInjects {

    final class Initializer {
        public Initializer() {
        }

        public static TrainApplicationComponent init(final TrainApplicationLike trainApplicationLike) {
            return DaggerTrainApplicationComponent.builder()
                    .globalComponent(trainApplicationLike.getGlobalComponent())
                    .trainApplicatonModule(new TrainApplicatonModule(trainApplicationLike))
                    .build();
        }
    }
}
