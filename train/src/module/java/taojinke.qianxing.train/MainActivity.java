package taojinke.qianxing.train;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.OnClick;
import taojinke.qianxing.train.base.DaggerActivity;
import taojinke.qianxing.train.dagger.activity.ActivityComponent;
import taojinke.qianxing.train.ui.home.fragment.HomeFragment;
import taojinke.qianxing.train.ui.train.fragment.TrainFragment;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/11+16:19
 * 修改人：
 * 修改时间：2019/3/11+16:19
 * 修改备注：
 * ***********************************************
 */
public class MainActivity extends DaggerActivity {
    @BindView(R.id.home)
    TextView home;
    @BindView(R.id.train)
    TextView train;
    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private TrainFragment trainFragment;

    @Override
    protected void inject(ActivityComponent activityComponent) {

    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {

        fragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        trainFragment = new TrainFragment();

    }

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_main;
    }


    @OnClick(R.id.home)
    public void onHomeClicked() {
        swithFragment(mContent, homeFragment);
    }

    @OnClick(R.id.train)
    public void onTrainClicked() {
        swithFragment(mContent, trainFragment);
    }

    Fragment mContent;

    private void swithFragment(Fragment from, Fragment to) {
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        mContent = to;
        if (from == null) {
            transaction.add(R.id.content, mContent).show(mContent).commitAllowingStateLoss();
        } else {
            if (to.isAdded()) {
                transaction.hide(from).show(to).commitAllowingStateLoss();
            } else {
                transaction.add(R.id.content, to).hide(from).show(to).commitAllowingStateLoss();
            }
        }
    }

}
