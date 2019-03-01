package taojinke.qianxing.earlywarning.ui.clazz.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.OnClick;
import taojinke.qianxing.earlywarning.MainActivity;
import taojinke.qianxing.earlywarning.R;
import taojinke.qianxing.earlywarning.base.DaggerFragment;
import taojinke.qianxing.earlywarning.dagger.fragment.FragmentComponent;
import taojinke.qianxing.lib_weight.loading.LoadingHelper;
import taojinke.qianxing.lib_weight.loading.callback.OnRetryClickListener;

import javax.inject.Inject;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.earlywarning.ui.clazz.fragment
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/1+15:37
 * 修改人：
 * 修改时间：2019/3/1+15:37
 * 修改备注：
 * ***********************************************
 */
public class TaskWaitFragment extends DaggerFragment implements TaskWaitContract.ITaskWaitView, OnRetryClickListener {
    @Inject
    TaskWaitContract.ITaskWaitPresenter mPresenter;
    @BindView(R.id.historyFinishTaskTv)
    TextView historyFinishTaskTv;
    @BindView(R.id.historyFinishLayout)
    RelativeLayout historyFinishLayout;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.smart)
    SwipeRefreshLayout smart;
    @BindView(R.id.noDataLayout)
    RelativeLayout noDataLayout;
    @BindView(R.id.datalayout)
    LinearLayout datalayout;
    @BindView(R.id.getTv)
    TextView getTv;
    @BindView(R.id.linearlayout)
    LinearLayout linearlayout;
    private LoadingHelper loadingHelper;

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.task_fragment_wait;
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
        loadingHelper = LoadingHelper.with(smart);
        loadingHelper.setOnRetryClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getmContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycle.setLayoutManager(linearLayoutManager);
        recycle.setAdapter(mPresenter.getAdapter());
        smart.setOnRefreshListener(() -> {
            mPresenter.tryLoadData();
            mPresenter.getServiceHours();
        });
        mPresenter.tryLoadData();
        mPresenter.getServiceHours();
    }


    @Override
    public void showNormal() {
        loadingHelper.restore();

    }

    @Override
    public void showNoNetwork() {
        loadingHelper.showNoNetwork();
    }

    @Override
    public void showError() {
        loadingHelper.showError();
    }

    @Override
    public void showEmpty() {
        datalayout.setVisibility(View.GONE);
        noDataLayout.setVisibility(View.VISIBLE);
        linearlayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

    @Override
    public void stopRefresh() {
        smart.setRefreshing(false);
    }


    @Override
    public void getServiceHoursNum(String serviceHoursNum) {
        double hoursNum = Double.valueOf(serviceHoursNum);
        int hours = (int) hoursNum;
        historyFinishTaskTv.setText("历史共完成" + hours + "小时任务");
    }


    @Override
    public void onRetry(@NonNull View view) {
        mPresenter.tryLoadData();
        mPresenter.getServiceHours();
    }

    @OnClick({R.id.historyFinishLayout, R.id.getTv})
    public void onViewClick(View view) {

    }

}
