package taojinke.qianxing.train.ui.train.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import taojinke.qianxing.core.DensityUtil;
import taojinke.qianxing.lib_weight.TitlePagerAdapter;
import taojinke.qianxing.lib_kernel.http.net.rx.databus.RxBus;
import taojinke.qianxing.train.R;
import taojinke.qianxing.train.base.DaggerFragment;
import taojinke.qianxing.train.dagger.fragments.FragmentComponent;
import taojinke.qianxing.train.ui.train.fragment.base.BaseTrainFragment;
import taojinke.qianxing.train.ui.train.fragment.task.TaskTrainFragment;


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
    @BindView(R.id.tablayout)
    CommonTabLayout tablayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private String[] titles = {"基础培训", "任务培训"};

    class TabEntity implements CustomTabEntity {

        private String title;

        TabEntity(String title) {
            this.title = title;
        }

        @Override
        public String getTabTitle() {
            return title;
        }

        @Override
        public int getTabSelectedIcon() {
            return 0;
        }

        @Override
        public int getTabUnselectedIcon() {
            return 0;
        }
    }

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

        BaseTrainFragment baseTrainFragment = new BaseTrainFragment();
        TaskTrainFragment trainFragment = new TaskTrainFragment();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(baseTrainFragment);
        fragments.add(trainFragment);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtil.dip2px(getmContext(), 48));
        tablayout.setLayoutParams(layoutParams);
        for (String title : titles) {
            mTabEntities.add(new TabEntity(title));
        }
        tablayout.setTabData(mTabEntities);
        tablayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        TitlePagerAdapter adapter = new TitlePagerAdapter(getChildFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tablayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        if (getArguments() != null) {
            int initPagePosition = getArguments().getInt("childPosition", 0);
            viewPager.setCurrentItem(initPagePosition);
        }
        RxBus.getInstance().register(this);

    }
}
