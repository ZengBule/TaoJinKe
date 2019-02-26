package taojinke.qianxing.task.dagger.fragment.module;

import dagger.Module;
import taojinke.qianxing.task.base.DaggerFragment;

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

    @Provides
    @FragmentScope
    taojinke.qianxing.task.ui.status.fragment.TaskExecutingContract.ITaskExecutingView providerTaskExecutingView() {
        return (taojinke.qianxing.task.ui.status.fragment.TaskExecutingContract.ITaskExecutingView) getDaggerFragment();
    }
}
