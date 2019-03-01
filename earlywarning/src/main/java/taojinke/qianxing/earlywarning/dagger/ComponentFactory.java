package taojinke.qianxing.earlywarning.dagger;


import taojinke.qianxing.earlywarning.app.TaskApplicationLikeImpl;
import taojinke.qianxing.earlywarning.base.DaggerActivity;
import taojinke.qianxing.earlywarning.base.DaggerFragment;
import taojinke.qianxing.earlywarning.dagger.activity.ActivityComponent;
import taojinke.qianxing.earlywarning.dagger.application.ApplicationComponent;
import taojinke.qianxing.earlywarning.dagger.fragment.FragmentComponent;

public class ComponentFactory {

    private ComponentFactory() {
    }

    public static ApplicationComponent createApplicationComponent(final TaskApplicationLikeImpl application) {
        return ApplicationComponent.Initializer.init(application);
    }

    public static ActivityComponent createActivityComponent(final DaggerActivity daggerActivity, final TaskApplicationLikeImpl taskApplicationLike) {
        return ActivityComponent.Initalizer.init(daggerActivity, taskApplicationLike.getApplicationComponent());
    }

    public static FragmentComponent createFragmentComponent(final DaggerFragment daggerFragment, final TaskApplicationLikeImpl copyApplicationLike) {
        return FragmentComponent.Initializer.init(daggerFragment, copyApplicationLike.getApplicationComponent());
    }
}
