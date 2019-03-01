package taojinke.qianxing.earlywarning.dagger.fragment.module;


import dagger.Module;
import dagger.Provides;
import taojinke.qianxing.earlywarning.base.DaggerFragment;
import taojinke.qianxing.earlywarning.dagger.fragment.FragmentComponent;
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

    @Provides
    @FragmentScope
    taojinke.qianxing.earlywarning.ui.executing.TaskExecutingContract.ITaskExecutingPresenter providerTaskExecutingPresenter() {
        taojinke.qianxing.earlywarning.ui.executing.TaskExecutingPresenter presenter = new taojinke.qianxing.earlywarning.ui.executing.TaskExecutingPresenter();
        getFragmentComponent().inject(presenter);
        return presenter;
    }

    @Provides
    @FragmentScope
    taojinke.qianxing.earlywarning.ui.clazz.fragment.TaskWaitContract.ITaskWaitPresenter providerTaskWaitPresenter() {
        taojinke.qianxing.earlywarning.ui.clazz.fragment.TaskWaitPresenter presenter = new taojinke.qianxing.earlywarning.ui.clazz.fragment.TaskWaitPresenter();
        getFragmentComponent().inject(presenter);
        return presenter;
    }
}
