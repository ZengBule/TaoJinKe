package taojinke.qianxing.train.dagger.fragments.module;

import dagger.Module;
import taojinke.qianxing.lib_base.dagger.FragmentScope;
import taojinke.qianxing.train.base.DaggerFragment;
import taojinke.qianxing.train.dagger.fragments.FragmentComponent;

/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.dagger.fragments.module
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2018/12/18+11:27
 * 修改人：
 * 修改时间：2018/12/18+11:27
 * 修改备注：
 * ***********************************************
 */
@Module
public class FragmentPresenterModule {

    private final DaggerFragment daggerFragment;

    public FragmentPresenterModule(final DaggerFragment daggerFragment) {
        this.daggerFragment = daggerFragment;
    }

    @FragmentScope
    private FragmentComponent getFragmentComponent() {
        return daggerFragment.getFragmentComponent();
    }

    private DaggerFragment getDaggerFragment() {
        return daggerFragment;
    }
}
