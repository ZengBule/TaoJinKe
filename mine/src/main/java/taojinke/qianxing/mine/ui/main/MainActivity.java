package taojinke.qianxing.mine.ui.main;

import android.os.Bundle;

import taojinke.qianxing.mine.R;
import taojinke.qianxing.mine.base.DaggerActivity;
import taojinke.qianxing.mine.dagger.activity.ActivityComponent;

import javax.inject.Inject;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.mine.ui.main
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/21+16:11
 * 修改人：
 * 修改时间：2019/2/21+16:11
 * 修改备注：
 * ***********************************************
 */
public class MainActivity extends DaggerActivity implements MainContract.IMainView {
    @Inject
    MainContract.IMainPresenter mPresenter;

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.mine_activity_main;
    }
}
