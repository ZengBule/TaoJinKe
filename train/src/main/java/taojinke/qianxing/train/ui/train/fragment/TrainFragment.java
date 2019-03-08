package taojinke.qianxing.train.ui.train.fragment;

import android.os.Bundle;

import taojinke.qianxing.train.R;
import taojinke.qianxing.train.base.DaggerFragment;
import taojinke.qianxing.train.dagger.fragments.FragmentComponent;

import javax.inject.Inject;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.ui.train.fragment
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/7+18:11
 * 修改人：
 * 修改时间：2019/3/7+18:11
 * 修改备注：
 * ***********************************************
 */
public class TrainFragment extends DaggerFragment implements TrainContract.ITrainView {
    @Inject
    TrainContract.ITrainPresenter mPresenter;

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.train_fragment_train;
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {

    }
}
