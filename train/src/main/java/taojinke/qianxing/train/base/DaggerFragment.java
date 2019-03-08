package taojinke.qianxing.train.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import taojinke.qianxing.lib_base.app.LifecycleApplication;
import taojinke.qianxing.lib_base.base.BaseActivity;
import taojinke.qianxing.lib_base.base.BaseFragment;
import taojinke.qianxing.train.app.TrainApplicationLike;
import taojinke.qianxing.train.dagger.ComponentFactory;
import taojinke.qianxing.train.dagger.fragments.FragmentComponent;

/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.base
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2018/12/18+10:17
 * 修改人：
 * 修改时间：2018/12/18+10:17
 * 修改备注：
 * ***********************************************
 *
 * @author Administrator
 */
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
                    ((LifecycleApplication) getDaggerActivity().getApplication())
                            .fetchApplicationLike(TrainApplicationLike.class));
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
