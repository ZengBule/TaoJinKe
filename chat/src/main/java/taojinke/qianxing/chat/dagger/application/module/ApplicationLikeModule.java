package taojinke.qianxing.chat.dagger.application.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.chat.app.ChatApplicationLikeImpl;
import taojinke.qianxing.lib_base.dagger.ModuleSingleton;

/**
 * 提供本模块的application
 */
@Module
public class ApplicationLikeModule {

    private ChatApplicationLikeImpl applicationLike;

    public ApplicationLikeModule(ChatApplicationLikeImpl applicationLike) {
        this.applicationLike = applicationLike;
    }

    @Provides
    @ModuleSingleton
    Application providerApplication() {
        return applicationLike.getApplication();
    }

    @Provides
    @ModuleSingleton
    ChatApplicationLikeImpl providerApplicationLike() {
        return applicationLike;
    }

    public interface Exposes {
        ChatApplicationLikeImpl application();

        Application getApplication();
    }
}
