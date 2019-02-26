package taojinke.qianxing.task.ui.status.fragment;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import taojinke.qianxing.lib_weight.countdownview.CountdownView;
import taojinke.qianxing.task.R;
import taojinke.qianxing.task.base.DaggerFragment;
import taojinke.qianxing.task.dagger.fragment.FragmentComponent;

import javax.inject.Inject;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.task.ui.status.fragment
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/22+11:21
 * 修改人：
 * 修改时间：2019/2/22+11:21
 * 修改备注：
 * ***********************************************
 */
public class TaskExecutingFragment extends DaggerFragment implements TaskExecutingContract.ITaskExecutingView {
    @Inject
    TaskExecutingContract.ITaskExecutingPresenter mPresenter;

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

    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showNoNetwork() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty(String s) {

    }

    @Override
    public void stopRefresh() {

    }

    @Override
    public TextView getTaskStatus() {
        return null;
    }

    @Override
    public TextView getLongTime() {
        return null;
    }

    @Override
    public TextView getHintText() {
        return null;
    }

    @Override
    public LinearLayout getServiceStatusLinearLayout() {
        return null;
    }

    @Override
    public RelativeLayout getDriectIncomeLayout() {
        return null;
    }

    @Override
    public TextView getIncomeTextView() {
        return null;
    }

    @Override
    public TextView getCountAlarmTextView() {
        return null;
    }

    @Override
    public CountdownView getCountdownView() {
        return null;
    }

    @Override
    public void showBottomLayout(boolean isShow, String serviceState) {

    }
}
