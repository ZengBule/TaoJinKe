package taojinke.qianxing.earlywarning.dagger.application.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.earlywarning.app.TaskApplicationLikeImpl;
import taojinke.qianxing.lib_base.dagger.ModuleSingleton;

/**
 * 提供本模块的application
 */
@Module
public class ApplicationLikeModule {

    private TaskApplicationLikeImpl applicationLike;

    public ApplicationLikeModule(TaskApplicationLikeImpl applicationLike) {
        this.applicationLike = applicationLike;
    }

    @Provides
    @ModuleSingleton
    Application providerApplication() {
        return applicationLike.getApplication();
    }

    @Provides
    @ModuleSingleton
    TaskApplicationLikeImpl providerApplicationLike() {
        return applicationLike;
    }

    public interface Exposes {
        TaskApplicationLikeImpl application();

        Application getApplication();
    }
}
