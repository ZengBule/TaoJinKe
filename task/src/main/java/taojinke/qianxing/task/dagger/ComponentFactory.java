package taojinke.qianxing.task.dagger;


import taojinke.qianxing.task.app.TaskApplicationLikeImpl;
import taojinke.qianxing.task.base.DaggerActivity;
import taojinke.qianxing.task.base.DaggerFragment;
import taojinke.qianxing.task.dagger.activity.ActivityComponent;
import taojinke.qianxing.task.dagger.application.ApplicationComponent;
import taojinke.qianxing.task.dagger.fragment.FragmentComponent;

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
