package taojinke.qianxing.mine.dagger.application.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.lib_base.dagger.ModuleSingleton;
import taojinke.qianxing.mine.app.MineApplicationLikeImpl;

/**
 * 提供本模块的application
 */
@Module
public class ApplicationLikeModule {

    private MineApplicationLikeImpl applicationLike;

    public ApplicationLikeModule(MineApplicationLikeImpl applicationLike) {
        this.applicationLike = applicationLike;
    }

    @Provides
    @ModuleSingleton
    Application providerApplication() {
        return applicationLike.getApplication();
    }

    @Provides
    @ModuleSingleton
    MineApplicationLikeImpl providerApplicationLike() {
        return applicationLike;
    }

    public interface Exposes {
        MineApplicationLikeImpl application();

        Application getApplication();
    }
}
