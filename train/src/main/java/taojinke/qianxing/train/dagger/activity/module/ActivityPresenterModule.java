package taojinke.qianxing.train.dagger.activity.module;

import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.lib_base.dagger.ActivityScope;
import taojinke.qianxing.train.base.DaggerActivity;
import taojinke.qianxing.train.dagger.activity.ActivityComponent;

/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.dagger.activity.module
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2018/12/18+10:20
 * 修改人：
 * 修改时间：2018/12/18+10:20
 * 修改备注：
 * ***********************************************
 */
@Module
public class ActivityPresenterModule {
    private final DaggerActivity daggerActivity;

    public ActivityPresenterModule(DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    public ActivityComponent getActivityComponent() {
        return daggerActivity.getActivityComponent();
    }


}
