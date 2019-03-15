package taojinke.qianxing.train.dagger.fragments.module;

import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.lib_base.dagger.FragmentScope;
import taojinke.qianxing.train.base.DaggerFragment;

/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.dagger.fragments.module
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2018/12/18+11:26
 * 修改人：
 * 修改时间：2018/12/18+11:26
 * 修改备注：
 * ***********************************************
 */
@Module
public class FragmentModule {
    private DaggerFragment daggerFragment;

    public FragmentModule(DaggerFragment daggerFragment) {
        this.daggerFragment = daggerFragment;
    }

    public DaggerFragment getDaggerFragment() {
        return daggerFragment;
    }

    @Provides
    @FragmentScope
    taojinke.qianxing.train.ui.home.fragment.HomeContract.IHomeView providerHomeView() {
        return (taojinke.qianxing.train.ui.home.fragment.HomeContract.IHomeView) getDaggerFragment();
    }

    @Provides
    @FragmentScope
    taojinke.qianxing.train.ui.train.fragment.base.BaseTrainContract.IBaseTrainView providerBaseTrainView() {
        return (taojinke.qianxing.train.ui.train.fragment.base.BaseTrainContract.IBaseTrainView) getDaggerFragment();
    }

    @Provides
    @FragmentScope
    taojinke.qianxing.train.ui.train.fragment.task.TaskTrainContract.ITaskTrainView providerTaskTrainView() {
        return (taojinke.qianxing.train.ui.train.fragment.task.TaskTrainContract.ITaskTrainView) getDaggerFragment();
    }

    @Provides
    @FragmentScope
    taojinke.qianxing.train.ui.train.fragment.TrainContract.ITrainView providerTrainView() {
        return (taojinke.qianxing.train.ui.train.fragment.TrainContract.ITrainView) getDaggerFragment();
    }



    @Provides
    @FragmentScope
    taojinke.qianxing.train.ui.train.fragment.base.clazz.TrainClassContract.ITrainClassView providerTrainClassView() {
        return (taojinke.qianxing.train.ui.train.fragment.base.clazz.TrainClassContract.ITrainClassView) getDaggerFragment();
    }

    @Provides
    @FragmentScope
    taojinke.qianxing.train.ui.train.fragment.base.mojor.ChoseMojorContract.IChoseMojorView providerChoseMojorView() {
        return (taojinke.qianxing.train.ui.train.fragment.base.mojor.ChoseMojorContract.IChoseMojorView) getDaggerFragment();
    }
}
