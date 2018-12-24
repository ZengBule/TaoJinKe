package taojinke.qianxing.chat.dagger;


import taojinke.qianxing.chat.app.ChatApplicationLikeImpl;
import taojinke.qianxing.chat.base.DaggerActivity;
import taojinke.qianxing.chat.base.DaggerFragment;
import taojinke.qianxing.chat.dagger.activity.ActivityComponent;
import taojinke.qianxing.chat.dagger.application.ApplicationComponent;
import taojinke.qianxing.chat.dagger.fragment.FragmentComponent;

public class ComponentFactory {

    private ComponentFactory() {
    }

    public static ApplicationComponent createApplicationComponent(final ChatApplicationLikeImpl application) {
        return ApplicationComponent.Initializer.init(application);
    }

    public static ActivityComponent createActivityComponent(final DaggerActivity daggerActivity, final ChatApplicationLikeImpl taskApplicationLike) {
        return ActivityComponent.Initalizer.init(daggerActivity, taskApplicationLike.getApplicationComponent());
    }

    public static FragmentComponent createFragmentComponent(final DaggerFragment daggerFragment, final ChatApplicationLikeImpl copyApplicationLike) {
        return FragmentComponent.Initializer.init(daggerFragment, copyApplicationLike.getApplicationComponent());
    }
}
