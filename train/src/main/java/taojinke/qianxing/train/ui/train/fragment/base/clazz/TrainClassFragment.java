package taojinke.qianxing.train.ui.train.fragment.base.clazz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import taojinke.qianxing.core.DensityUtil;
import taojinke.qianxing.lib_kernel.http.BaseBean;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;
import taojinke.qianxing.train.MainActivity;
import taojinke.qianxing.train.R;
import taojinke.qianxing.train.base.DaggerFragment;
import taojinke.qianxing.train.dagger.fragments.FragmentComponent;
import taojinke.qianxing.train.ui.train.fragment.base.bean.OtherMajorBean;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.ui.train.fragment.base.clazz
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/12+17:51
 * 修改人：
 * 修改时间：2019/3/12+17:51
 * 修改备注：
 * ***********************************************
 */
public class TrainClassFragment extends DaggerFragment implements TrainClassContract.ITrainClassView {
    @Inject
    TrainClassContract.ITrainClassPresenter mPresenter;
    @BindView(R.id.itemName)
    TextView itemName;
    @BindView(R.id.myTeacher)
    TextView myTeacher;
    @BindView(R.id.teacherLayout)
    LinearLayout teacherLayout;
    @BindView(R.id.subjectHead)
    LinearLayout subjectHead;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.train_fragment_train_class;
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DensityUtil.dip2px(getmContext(), 48));
        subjectHead.setLayoutParams(layoutParams);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getmContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycle.setLayoutManager(linearLayoutManager);
        recycle.setAdapter(mPresenter.getMajorContentAdapter());

        refresh.setOnRefreshListener(() -> {
            if (itemName.getTag() != null) {
                mPresenter.getMajorContentByMajorId((int) itemName.getTag());
            } else {
                setStopOnRefresh();
            }
        });
        registerLockReceiver();

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int majorId = bundle.getInt("majorId");
            String majorTitle = bundle.getString("majorTitle");
            itemName.setText(majorTitle);
            itemName.setTag(majorId);
            if (TextUtils.isEmpty(majorTitle)) {
                mPresenter.getMajorData();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (itemName.getTag() != null) {
            mPresenter.getMajorContentByMajorId((int) itemName.getTag());
        }
    }

    private void registerLockReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        getmContext().registerReceiver(lockReceiver, filter);
    }

    boolean isLockedScreen;
    public BroadcastReceiver lockReceiver = new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("recorderPageStayTime", "拦截到一个广播：" + intent.getAction());
            if (TextUtils.equals(intent.getAction(), Intent.ACTION_SCREEN_OFF)) {
                isLockedScreen = true;
                SharedPreferenceUtils.saveTrainPageStartTime(getmContext(), majorId, 0);
            } else if (TextUtils.equals(intent.getAction(), Intent.ACTION_SCREEN_ON)
                    || TextUtils.equals(intent.getAction(), Intent.ACTION_USER_PRESENT)) {
                isLockedScreen = false;
            }
        }
    };

    @Override
    public void onDestroy() {
        //清理页面停留记录时长
        SharedPreferenceUtils.saveTrainPageStartTime(getmContext(), majorId, 0);
        Log.d("TrainFragment", "life - >onDestroy = ");
        getmContext().unregisterReceiver(lockReceiver);
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TrainFragment", "life - >onDestroy = ");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d("TrainFragment", "life - >hidden = " + hidden);
        if (hidden) {
            recorderPageStayTime();
        }

    }

    @Override
    public void setStopOnRefresh() {
        refresh.setRefreshing(false);
        refresh.scrollTo(0, 0);
    }

    @Override
    public void initMojorTitle(List<OtherMajorBean> list) {
        itemName.setText(list.get(0).majorTitle);
        itemName.setTag(list.get(0).majorId);
    }

    private String majorId;

    private void recorderPageStayTime() {
        if (!TextUtils.isEmpty(majorId)) {
            long startTime = SharedPreferenceUtils.getTrainPageStartTime(getmContext(), majorId);
            if (startTime > 0) {
                long endTime;
                if (SharedPreferenceUtils.getTrainPageEndTime(getmContext(), majorId) > 0) {
                    endTime = SharedPreferenceUtils.getTrainPageEndTime(getmContext(), majorId);
                } else {
                    endTime = System.currentTimeMillis();
                }
                final int time = (int) ((endTime - startTime) / 1000);
                if (time > 0) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("majorId", majorId);
                    map.put("learningDuration", time + "");
                    SharedPreferenceUtils.saveTrainPageStartTime(getmContext(), majorId, 0);
                    Log.d("recorderPageStayTime", "recorderPageStayTime map" + map.toString());
//                    CourseModel.saveLearningDuration3(map, new BaseSubscriber<BaseBean>() {
//                        @Override
//                        public void onNextWithCatchError(BaseBean value) {
//                            super.onNextWithCatchError(value);
//                            Log.d("recorderPageStayTime", "recorderPageStayTime value.isSuccess()" + value.isSuccess());
//                        }
//                    });
                } else {
                    SharedPreferenceUtils.clearTrainPageTime(getmContext());
                }
            }
        }
    }
}
