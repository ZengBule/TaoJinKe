package taojinke.qianxing.mine.dagger.fragment.module;

import dagger.Module;
import taojinke.qianxing.lib_base.dagger.FragmentScope;
import taojinke.qianxing.mine.base.DaggerFragment;
import taojinke.qianxing.mine.dagger.fragment.FragmentComponent;

/**
 * ***********************************************
 * 包路径：
 * 类描述：
 * 创建人：Zengxialang[PHONE：18613223863]
 * 创建时间：2018/12/13
 * 修改人：
 * 修改时间：2018/12/13
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
