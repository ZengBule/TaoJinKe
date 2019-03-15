package taojinke.qianxing.train.ui.train.fragment.base.first;

import android.os.Bundle;

import taojinke.qianxing.train.R;
import taojinke.qianxing.train.base.DaggerFragment;
import taojinke.qianxing.train.dagger.fragments.FragmentComponent;

import javax.inject.Inject;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.ui.train.fragment.base.first
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/12+17:49
 * 修改人：
 * 修改时间：2019/3/12+17:49
 * 修改备注：
 * ***********************************************
 */
public class FirstIntoTrainFragment extends DaggerFragment implements FirstIntoTrainContract.IFirstIntoTrainView {
    @Inject
    FirstIntoTrainContract.IFirstIntoTrainPresenter mPresenter;

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.train_fragment_first_into_train;
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {

    }
}
