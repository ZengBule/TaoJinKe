package taojinke.qianxing.train.dagger.fragments.module;

import dagger.Module;
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
}
