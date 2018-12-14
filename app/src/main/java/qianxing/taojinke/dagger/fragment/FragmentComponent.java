package qianxing.taojinke.dagger.fragment;

import dagger.Component;
import qianxing.taojinke.base.DaggerFragment;
import qianxing.taojinke.dagger.application.ApplicationComponent;
import qianxing.taojinke.dagger.fragment.module.FragmentModule;
import qianxing.taojinke.dagger.fragment.module.FragmentPresenterModule;
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
@FragmentScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                FragmentModule.class,
                FragmentPresenterModule.class
        }
)
public interface FragmentComponent extends FragmentComponentInjects{

    final class Initializer {
        static public FragmentComponent init(final DaggerFragment fragment, final ApplicationComponent applicationComponent) {

            return DaggerFragmentComponent.builder()
                    .applicationComponent(applicationComponent)
                    .fragmentModule(new FragmentModule(fragment))
                    .fragmentPresenterModule(new FragmentPresenterModule(fragment))
                    .build();
        }
    }
}
