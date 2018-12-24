package taojinke.qianxing.train.dagger.application;

import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.lib_base.dagger.ModuleSingleton;
import taojinke.qianxing.train.app.TrainApplicationLike;

@Module
public class TrainApplicatonModule {

    private TrainApplicationLike trainApplicationLike;


    public TrainApplicatonModule(TrainApplicationLike trainApplicationLike) {
        this.trainApplicationLike = trainApplicationLike;
    }


    @Provides
    @ModuleSingleton
    TrainApplicationLike providerApplicationLike() {
        return trainApplicationLike;
    }

    public interface Exposes {
        TrainApplicationLike application();
    }
}
