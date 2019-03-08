package qianxing.taojinke.ui.guide;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.guide
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2019/1/15+17:56
 * 修改人：
 * 修改时间：2019/1/15+17:56
 * 修改备注：
 * ***********************************************
 */
public class ViewPagerAdapter extends PagerAdapter {
    private ArrayList<ImageView> imageViews;

    public ViewPagerAdapter(ArrayList<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    /**
     * 获取当前要显示对象的数量
     */
    @Override
    public int getCount() {
        return imageViews.size();
    }

    /**
     * 判断是否用对象生成界面
     */
    @Override
    public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
        return arg0 == arg1;
    }

    /**
     * 从ViewGroup中移除当前对象（图片）
     */
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(imageViews.get(position));
    }

    /**
     * 当前要显示的对象（图片）
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(imageViews.get(position));
        return imageViews.get(position);
    }
}
