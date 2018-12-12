package taojinke.qianxing.lib_base.app.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import taojinke.qianxing.lib_base.app.dagger.module.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface GlobalComponent {
}
