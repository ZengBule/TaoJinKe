package taojinke.qianxing.train.ui.train.fragment.base.mojor;

import android.os.Bundle;

import taojinke.qianxing.train.R;
import taojinke.qianxing.train.base.DaggerFragment;
import taojinke.qianxing.train.dagger.fragments.FragmentComponent;

import javax.inject.Inject;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.ui.train.fragment.base.mojor
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/12+17:51
 * 修改人：
 * 修改时间：2019/3/12+17:51
 * 修改备注：
 * ***********************************************
 */
public class ChoseMojorFragment extends DaggerFragment implements ChoseMojorContract.IChoseMojorView {
    @Inject
    ChoseMojorContract.IChoseMojorPresenter mPresenter;

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.train_fragment_chose_mojor;
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {

    }
}
