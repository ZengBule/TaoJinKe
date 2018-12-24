package taojinke.qianxing.train.dagger.fragments;

import dagger.Component;
import taojinke.qianxing.lib_base.dagger.FragmentScope;
import taojinke.qianxing.train.app.TrainApplicationLike;
import taojinke.qianxing.train.base.DaggerFragment;
import taojinke.qianxing.train.dagger.application.TrainApplicationComponent;
import taojinke.qianxing.train.dagger.application.TrainApplicatonModule;
import taojinke.qianxing.train.dagger.fragments.module.FragmentModule;
import taojinke.qianxing.train.dagger.fragments.module.FragmentPresenterModule;

/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.dagger.fragments
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2018/12/18+11:26
 * 修改人：
 * 修改时间：2018/12/18+11:26
 * 修改备注：
 * ***********************************************
 */
@FragmentScope
@Component(dependencies = TrainApplicationComponent.class, modules = {FragmentModule.class, FragmentPresenterModule.class})
public interface FragmentComponent extends FragmentComponentInjects {
    final class Initializer {

        static public FragmentComponent init(final DaggerFragment daggerFragment, final TrainApplicationComponent trainApplicationLike) {
            return DaggerFragmentComponent.builder()
                    .trainApplicationComponent(trainApplicationLike)
                    .fragmentModule(new FragmentModule(daggerFragment))
                    .fragmentPresenterModule(new FragmentPresenterModule(daggerFragment))
                    .build();
        }
    }
}
