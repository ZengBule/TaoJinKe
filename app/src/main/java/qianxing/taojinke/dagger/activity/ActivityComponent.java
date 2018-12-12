package qianxing.taojinke.dagger.activity;

import dagger.Component;
import qianxing.taojinke.dagger.activity.module.ActivityModule;
import qianxing.taojinke.dagger.activity.module.ActivityPresenterModule;
import taojinke.qianxing.lib_base.dagger.ActivityScope;

@ActivityScope
@Component(modules = {ActivityModule.class, ActivityPresenterModule.class})
public interface ActivityComponent extends ActivityComponentInjects {

}
