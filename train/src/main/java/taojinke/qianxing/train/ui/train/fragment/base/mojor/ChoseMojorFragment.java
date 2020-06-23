package taojinke.qianxing.train.ui.train.fragment.base.mojor;

import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import taojinke.qianxing.lib_weight.loading.LoadingHelper;
import taojinke.qianxing.lib_weight.loading.callback.OnRetryClickListener;
import taojinke.qianxing.train.R;
import taojinke.qianxing.train.base.DaggerFragment;
import taojinke.qianxing.train.dagger.fragments.FragmentComponent;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.ui.train.fragment.base.mojor
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/12+17:51
 * 修改人：
 * 修改时间：2019/3/12+17:51
 * 修改备注：
 * ***********************************************
 */
public class ChoseMojorFragment extends DaggerFragment implements ChoseMojorContract.IChoseMojorView, OnRetryClickListener {
    @Inject
    ChoseMojorContract.IChoseMojorPresenter mPresenter;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;
    LoadingHelper loadingHelper;

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.train_fragment_chose_mojor;
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
        mPresenter.getMajorData();
        loadingHelper = LoadingHelper.with(swipeRefresh);
        loadingHelper.setOnRetryClickListener(this);
        initRecycle();
    }

    private void initRecycle() {
        LinearLayoutManager otherLinearLayoutManager = new LinearLayoutManager(getmContext());
        otherLinearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycle.setLayoutManager(otherLinearLayoutManager);
        recycle.setAdapter(mPresenter.getAdapter());
        swipeRefresh.setEnabled(true);
        swipeRefresh.setOnRefreshListener(() -> mPresenter.getMajorData());

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
        loadingHelper.showEmpty();
    }

    @Override
    public void stopRefresh() {
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void onRetry(@NonNull View view) {
        mPresenter.getMajorData();
    }
}
