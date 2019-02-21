package taojinke.qianxing.mine.ui.mine;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import taojinke.qianxing.mine.R;
import taojinke.qianxing.mine.base.DaggerFragment;
import taojinke.qianxing.mine.dagger.fragment.FragmentComponent;

import javax.inject.Inject;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.mine.ui.mine
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/21+14:52
 * 修改人：
 * 修改时间：2019/2/21+14:52
 * 修改备注：
 * ***********************************************
 */
@Route(path = "/mine/fragment")
public class MineFragment extends DaggerFragment implements MineContract.IMineView {
    @Inject
    MineContract.IMinePresenter mPresenter;

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.mine_fragment_mine;
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {

    }
}
