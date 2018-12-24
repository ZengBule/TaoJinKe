package taojinke.qianxing.train.dagger;

import taojinke.qianxing.train.app.TrainApplicationLike;
import taojinke.qianxing.train.base.DaggerActivity;
import taojinke.qianxing.train.base.DaggerFragment;
import taojinke.qianxing.train.dagger.activity.ActivityComponent;
import taojinke.qianxing.train.dagger.application.TrainApplicationComponent;
import taojinke.qianxing.train.dagger.fragments.FragmentComponent;

public class ComponentFactory {
    private ComponentFactory() {
    }

    public static TrainApplicationComponent createApplicationComponent(final TrainApplicationLike application) {
        return TrainApplicationComponent.Initializer.init(application);
    }

    public static ActivityComponent createActivityComponent(final DaggerActivity daggerActivity, final TrainApplicationLike taskApplicationLike) {
        return ActivityComponent.Initalizer.init(daggerActivity, taskApplicationLike.getApplicationComponent());
    }

    public static FragmentComponent createFragmentComponent(final DaggerFragment daggerFragment, final TrainApplicationLike copyApplicationLike) {
        return FragmentComponent.Initializer.init(daggerFragment, copyApplicationLike.getApplicationComponent());
    }
}
