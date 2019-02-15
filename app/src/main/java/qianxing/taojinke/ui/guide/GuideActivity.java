package qianxing.taojinke.ui.guide;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import qianxing.taojinke.R;
import qianxing.taojinke.ui.login.LoginActivity;
import taojinke.qianxing.lib_base.base.BaseActivity;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.guide
 * 类描述：
 *
 * @author ：曾小浪[PHONE：18613223863]
 * 创建时间：2019/1/15+16:43
 * 修改人：
 * 修改时间：2019/1/15+16:43
 * 修改备注：
 * <p>
 * ***********************************************
 */
public class GuideActivity extends BaseActivity {

    @BindView(R.id.guid_viewpager)
    ViewPager guidViewpager;
    @BindView(R.id.btn_enter)
    Button btnEnter;

    private static int[] mImageInt = {R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
        //设置每一张图片都填充窗口
        ViewPager.LayoutParams mParams = new ViewPager.LayoutParams();
        ArrayList<ImageView> imageViews = new ArrayList<>();

        for (int aMImageInt : mImageInt) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mParams);
            iv.setImageResource(aMImageInt);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(iv);
        }

        ViewPagerAdapter adapter = new ViewPagerAdapter(imageViews);
        guidViewpager.setAdapter(adapter);
        guidViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    btnEnter.setVisibility(View.GONE);
                } else if (position == 1) {
                    btnEnter.setVisibility(View.GONE);
                } else {
                    btnEnter.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    @Override
    protected int getLayoutResources() {
        return R.layout.guide_activity;
    }


    @OnClick(R.id.btn_enter)
    public void onViewClicked() {

        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("from_which_activity", "GuidActivity");
        startActivity(intent);
        setGuided();
        finish();
    }


    /**
     * method desc：设置已经引导过了，下次启动不用再次引导
     */
    private void setGuided() {
        PackageManager manager;
        PackageInfo info = null;

        manager = this.getPackageManager();
        try {
            info = manager.getPackageInfo(this.getPackageName(), 0);
            String versionName = info.versionName;
            SharedPreferenceUtils.saveVersionIDPerference(this, versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
