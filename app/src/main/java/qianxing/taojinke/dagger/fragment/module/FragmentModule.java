package qianxing.taojinke.dagger.fragment.module;

import dagger.Module;
import dagger.Provides;
import qianxing.taojinke.base.DaggerFragment;
import taojinke.qianxing.lib_base.dagger.FragmentScope;

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
public class FragmentModule {

    private final DaggerFragment fragment;

    public FragmentModule(final DaggerFragment fragment) {
        this.fragment = fragment;
    }

    public DaggerFragment getDaggerFragment() {
        return fragment;
    }

}
