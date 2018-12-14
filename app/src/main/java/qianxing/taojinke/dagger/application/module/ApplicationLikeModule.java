package qianxing.taojinke.dagger.application.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import qianxing.taojinke.TaoJinKeApplicationLike;
import taojinke.qianxing.lib_base.dagger.ModuleSingleton;

/**
 * 提供本模块的application
 */
@Module
public class ApplicationLikeModule {

    private TaoJinKeApplicationLike applicationLike;

    public ApplicationLikeModule(TaoJinKeApplicationLike applicationLike) {
        this.applicationLike = applicationLike;
    }

    @Provides
    @ModuleSingleton
    Application providerApplication() {
        return applicationLike.getApplication();
    }

    @Provides
    @ModuleSingleton
    TaoJinKeApplicationLike providerApplicationLike() {
        return applicationLike;
    }

    public interface Exposes {
        TaoJinKeApplicationLike application();

        Application getApplication();
    }
}
