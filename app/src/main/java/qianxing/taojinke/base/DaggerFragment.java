package qianxing.taojinke.base;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import qianxing.taojinke.TaoJinKeApplicationLike;
import qianxing.taojinke.dagger.ComponentFactory;
import qianxing.taojinke.dagger.fragment.FragmentComponent;
import taojinke.qianxing.lib_base.app.LifecycleApplication;
import taojinke.qianxing.lib_base.base.BaseActivity;
import taojinke.qianxing.lib_base.base.BaseFragment;

public abstract class DaggerFragment extends BaseFragment {

    private FragmentComponent fragmentComponent;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        inject(getFragmentComponent());
        super.onCreate(savedInstanceState);
    }

    public FragmentComponent getFragmentComponent() {
        if (fragmentComponent == null) {
            fragmentComponent = ComponentFactory.createFragmentComponent(this,
                    ((LifecycleApplication) getmContext().getApplication())
                            .fetchApplicationLike(TaoJinKeApplicationLike.class));
        }

        return fragmentComponent;
    }


    private DaggerActivity getDaggerActivity() {
        return ((DaggerActivity) getmContext());
    }

    protected abstract void inject(FragmentComponent fragmentComponent);

    public void launchActivity(Class<? extends BaseActivity> clazz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(getDaggerActivity(), clazz);
        if (bundle != null)
            intent.putExtras(bundle);
        startActivity(intent);

    }

    public void launchActivity(Class<? extends BaseActivity> clazz) {
        Intent intent = new Intent();
        intent.setClass(getDaggerActivity(), clazz);
        startActivity(intent);

    }
}
