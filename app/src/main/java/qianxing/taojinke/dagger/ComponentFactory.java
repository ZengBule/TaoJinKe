package qianxing.taojinke.dagger;


import qianxing.taojinke.TaoJinKeApplicationLike;
import qianxing.taojinke.base.DaggerActivity;
import qianxing.taojinke.base.DaggerFragment;
import qianxing.taojinke.dagger.activity.ActivityComponent;
import qianxing.taojinke.dagger.application.ApplicationComponent;
import qianxing.taojinke.dagger.fragment.FragmentComponent;

public class ComponentFactory {

    private ComponentFactory() {
    }

    public static ApplicationComponent createApplicationComponent(final TaoJinKeApplicationLike application) {
        return ApplicationComponent.Initializer.init(application);
    }

    public static ActivityComponent createActivityComponent(final DaggerActivity daggerActivity, final TaoJinKeApplicationLike taskApplicationLike) {
        return ActivityComponent.Initalizer.init(daggerActivity, taskApplicationLike.getApplicationComponent());
    }

    public static FragmentComponent createFragmentComponent(final DaggerFragment daggerFragment, final TaoJinKeApplicationLike copyApplicationLike) {
        return FragmentComponent.Initializer.init(daggerFragment, copyApplicationLike.getApplicationComponent());
    }
}
