package taojinke.qianxing.earlywarning.ui.executing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.ref.SoftReference;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.OnClick;
import taojinke.qianxing.earlywarning.R;
import taojinke.qianxing.earlywarning.base.DaggerFragment;
import taojinke.qianxing.earlywarning.dagger.fragment.FragmentComponent;
import taojinke.qianxing.earlywarning.ui.clazz.TaskWaitCompletActivity;
import taojinke.qianxing.lib_weight.countdownview.CountdownView;
import taojinke.qianxing.lib_weight.loading.LoadingHelper;
import taojinke.qianxing.lib_weight.loading.callback.OnRetryClickListener;
import taojinke.qianxing.lib_weight.pw.CommonPopupWindow;

import javax.inject.Inject;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.earlywarning.ui.executing
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/1+10:11
 * 修改人：
 * 修改时间：2019/3/1+10:11
 * 修改备注：
 * ***********************************************
 */
public class TaskExecutingFragment extends DaggerFragment implements TaskExecutingContract.ITaskExecutingView, OnRetryClickListener {
    @Inject
    TaskExecutingContract.ITaskExecutingPresenter mPresenter;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.smart)
    SwipeRefreshLayout smartRefresh;
    @BindView(R.id.clickSpread)
    TextView clickSpread;
    @BindView(R.id.status)
    TextView status;
    @BindView(R.id.hintTv)
    TextView hintTv;
    @BindView(R.id.value)
    TextView value;
    @BindView(R.id.longTime)
    TextView longTime;
    @BindView(R.id.countAlarmTv)
    TextView countAlarmTv;

    @BindView(R.id.countdownView)
    CountdownView countdownView;
    @BindView(R.id.serviceStatus)
    LinearLayout serviceStatus;
    @BindView(R.id.incomeLayout)
    RelativeLayout incomeLayout;

    @BindView(R.id.bottomLayout)
    RelativeLayout bottomLayout;
    @BindView(R.id.noAlarmLayout)
    RelativeLayout noAlarmLayout;
    @BindView(R.id.child)
    RelativeLayout child;

    private LoadingHelper loadingHelper;

    private CommonPopupWindow popupWindow;

    private Timer timer;

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.task_fragment_task_executing;
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {

        loadingHelper = LoadingHelper.with(smartRefresh);
        loadingHelper.setOnRetryClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycle.setLayoutManager(linearLayoutManager);
        recycle.setAdapter(mPresenter.getAdapter());
        smartRefresh.setOnRefreshListener(() -> {
            mPresenter.tryLoadData();
        });
        mPresenter.tryLoadData();
        popupWindow = mPresenter.createPopupWindow().initView(CommonPopupWindow.Location.BOTTOM);
        initTimer();
    }

    private void initTimer() {
        MyHandler myHandler = new MyHandler(getActivity());
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                myHandler.sendEmptyMessage(0x01);
            }
        };
        timer.schedule(timerTask, 1000 * 30, 1000 * 30);

        timer.purge();

    }


    @Override
    public void showNormal() {
        loadingHelper.restore();
        bottomLayout.setVisibility(View.VISIBLE);
        child.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoNetwork() {
        loadingHelper.showNoNetwork();
        bottomLayout.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        loadingHelper.showError();
        bottomLayout.setVisibility(View.GONE);
    }

    @Override
    public void showEmpty(String s) {
        loadingHelper.showError("暂无任务", "去待完成任务里面查询吧", R.mipmap.task_icon_none);
        bottomLayout.setVisibility(View.GONE);
    }


    @Override
    public void stopRefresh() {
        smartRefresh.setRefreshing(false);
    }

    @Override
    public TextView getTaskStatus() {
        return status;
    }

    @Override
    public TextView getLongTime() {
        return longTime;
    }

    @Override
    public TextView getHintText() {
        return hintTv;
    }

    @Override
    public LinearLayout getServiceStatusLinearLayout() {
        return serviceStatus;
    }

    @Override
    public RelativeLayout getDriectIncomeLayout() {
        return incomeLayout;
    }

    @Override
    public TextView getIncomeTextView() {
        return value;
    }


    @Override
    public TextView getCountAlarmTextView() {
        return countAlarmTv;
    }


    @Override
    public CountdownView getCountdownView() {
        return countdownView;
    }


    @Override
    public void showBottomLayout(boolean isShow, String serviceState) {

        if (TextUtils.equals(serviceState, "InService")) {
            if (isShow) {
                bottomLayout.setVisibility(View.VISIBLE);
                noAlarmLayout.setVisibility(View.GONE);
            } else {
                bottomLayout.setVisibility(View.GONE);
                noAlarmLayout.setVisibility(View.VISIBLE);
            }
        } else {
            bottomLayout.setVisibility(View.GONE);
            noAlarmLayout.setVisibility(View.GONE);
        }

        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }

    @OnClick(R.id.clickSpread)
    public void onClickSpreadClicked() {
        if (mPresenter.getAlarmData().size() > 0) {
            popupWindow.setAdapter(mPresenter.getAlarmData());
            popupWindow.showWindow(clickSpread, Gravity.BOTTOM);
        } else {
            showToast("暂无服务预警");
        }
    }

    @OnClick(R.id.lookServiceDetail)
    public void onLookSerciceDetail() {
        //lanuchActivity(AlarmRulerAndSepackActivity.class);
    }

    @Override
    public void onRetry(@NonNull View view) {

        //lanuchActivity(TaskWaitCompletActivity.class);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }


    @SuppressLint("HandlerLeak")
    class MyHandler extends Handler {
        SoftReference<Activity> mWeakReference;

        private MyHandler(Activity activity) {
            mWeakReference = new SoftReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x01:
                    mPresenter.tryLoadData();
                    break;
                default:
            }
        }
    }
}
