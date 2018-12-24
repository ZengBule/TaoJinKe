package taojinke.qianxing.mine.dagger;


import taojinke.qianxing.mine.app.MineApplicationLikeImpl;
import taojinke.qianxing.mine.base.DaggerActivity;
import taojinke.qianxing.mine.base.DaggerFragment;
import taojinke.qianxing.mine.dagger.activity.ActivityComponent;
import taojinke.qianxing.mine.dagger.application.ApplicationComponent;
import taojinke.qianxing.mine.dagger.fragment.FragmentComponent;

public class ComponentFactory {

    private ComponentFactory() {
    }

    public static ApplicationComponent createApplicationComponent(final MineApplicationLikeImpl application) {
        return ApplicationComponent.Initializer.init(application);
    }

    public static ActivityComponent createActivityComponent(final DaggerActivity daggerActivity, final MineApplicationLikeImpl taskApplicationLike) {
        return ActivityComponent.Initalizer.init(daggerActivity, taskApplicationLike.getApplicationComponent());
    }

    public static FragmentComponent createFragmentComponent(final DaggerFragment daggerFragment, final MineApplicationLikeImpl copyApplicationLike) {
        return FragmentComponent.Initializer.init(daggerFragment, copyApplicationLike.getApplicationComponent());
    }
}
