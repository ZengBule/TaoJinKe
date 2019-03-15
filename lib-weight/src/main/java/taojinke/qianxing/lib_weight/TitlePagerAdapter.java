package taojinke.qianxing.lib_weight;

import android.view.ViewGroup;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TitlePagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mlist;
    private String[] mTitles;
    private Fragment mCurrentFragment;

    public TitlePagerAdapter(FragmentManager fm, List<Fragment> list, String[] titles) {
        super(fm);
        mlist = list;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    //----------------------下面才是重点-----------------

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        mCurrentFragment = (Fragment) object;
        super.setPrimaryItem(container, position, object);
    }


    public Fragment getCurrentFragment() {
        return mCurrentFragment;
    }
}
