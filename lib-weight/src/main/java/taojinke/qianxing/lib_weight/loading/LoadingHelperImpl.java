package taojinke.qianxing.lib_weight.loading;

import android.content.Context;
import android.view.View;

import java.util.HashMap;

import taojinke.qianxing.lib_weight.R;
import taojinke.qianxing.lib_weight.loading.callback.OnRetryClickListener;
import taojinke.qianxing.lib_weight.loading.change.SwitchLayoutHelper;
import taojinke.qianxing.lib_weight.loading.view.IStatusView;

/**
 * 实际实现
 * Created by leeiides on 2017/6/23.
 */

class LoadingHelperImpl extends LoadingHelper {

    private StatusViewCreator mDefaultStatusViewCreator;

    private Context context;

    private View originView;
    private SwitchLayoutHelper mSwitchLayoutHelper;

    private HashMap<Status, IStatusView> mViewMap = new HashMap<>();
    private OnRetryClickListener mOnRetryClickListener;


    LoadingHelperImpl(IStatusView originView,
                      SwitchLayoutHelper switchLayout,
                      StatusViewCreator mDefaultStatusViewCreator) {
        this.mDefaultStatusViewCreator = mDefaultStatusViewCreator;
        this.originView = originView.getView();
        context = this.originView.getContext();
        this.mSwitchLayoutHelper = switchLayout;

        mViewMap.put(Status.NORMAL, originView);
        originView.getView().setTag(R.id.status_layout_origin_helper, this);
    }

    @Override
    public void showLoading(String message) {
        show(Status.LOADING, message, null, 0);
    }

    @Override
    public void showEmpty(String message, String button, int imageRes) {
        show(Status.EMPTY, message, button, imageRes);
    }

    @Override
    public void showError(String message, String button) {
        show(Status.ERROR, message, button, 0);
    }

    @Override
    public void showError(String message, String button, int img) {
        show(Status.ERROR, message, button, img);
    }

    @Override
    public void restore() {
        stopAnimationIfExist(mSwitchLayoutHelper.getCurrentStatusView());
        mSwitchLayoutHelper.switchLayout(mViewMap.get(Status.NORMAL));
    }


    @Override
    public void showNoNetwork(String message, String button) {
        show(Status.NETWORK, message, button, 0);
    }

    private void putCustomViewByStatus(Status status, IStatusView statusView) {
        mViewMap.put(status, statusView);
    }

    @Override
    public void removeAllView() {
        mViewMap.clear();
        mViewMap = null;
        originView = null;
        mSwitchLayoutHelper.removeAllViews();
        mSwitchLayoutHelper = null;
    }

    @Override
    public void setOnRetryClickListener(OnRetryClickListener l) {
        this.mOnRetryClickListener = l;
    }

    @Override
    public void putCustomView(IStatusView view) {
        mViewMap.put(Status.CUSTOM, view);
    }

    @Override
    public void showCustom(String message, String button) {
        show(Status.CUSTOM, message, button, 0);
    }

    @Override
    public void show(Status status, String message, String button, int res) {
        IStatusView statusView = mViewMap.get(status);

        if (statusView == null) {
            statusView = mDefaultStatusViewCreator.onCreateStatusView(context, status, mOnRetryClickListener);
            putCustomViewByStatus(status, statusView);
        }
        statusView.setMessage(message);
        statusView.setButtonText(button);
        if (res != 0) {
            statusView.setStatusImage(res);
        }
        stopAnimationIfExist(mSwitchLayoutHelper.getCurrentStatusView());
        startAnimationIfExist(statusView);

        mSwitchLayoutHelper.switchLayout(statusView);
    }


    private void stopAnimationIfExist(IStatusView currentView) {
        currentView.stopAnimation();
    }

    private void startAnimationIfExist(IStatusView currentView) {
        currentView.startAnimation();
    }
}
