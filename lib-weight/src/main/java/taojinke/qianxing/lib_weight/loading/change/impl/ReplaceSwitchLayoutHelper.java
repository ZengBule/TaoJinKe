package taojinke.qianxing.lib_weight.loading.change.impl;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import taojinke.qianxing.lib_weight.loading.change.SwitchLayoutHelper;
import taojinke.qianxing.lib_weight.loading.view.IStatusView;


/**
 * Created by leeiides on 2017/6/23.
 */

class ReplaceSwitchLayoutHelper implements SwitchLayoutHelper {

    private IStatusView mOriginView;

    private ViewGroup mParentView;

    private int indexOfView;

    private IStatusView mCurrentView;

    private ViewGroup.LayoutParams originParams;


    ReplaceSwitchLayoutHelper(@NonNull IStatusView view) {
        mOriginView = view;
        originParams = mOriginView.getView().getLayoutParams();

        if (mOriginView.getView().getParent() == null) {
            mParentView = (ViewGroup) mOriginView.getView().getRootView().findViewById(android.R.id.content);
        } else {
            mParentView = (ViewGroup) mOriginView.getView().getParent();
        }

        indexOfView = mParentView.indexOfChild(mOriginView.getView());

        mCurrentView = view;
    }

    @Override
    public synchronized void switchLayout(@NonNull IStatusView targetView) {
        if (mCurrentView == targetView) return;
        indexOfView = mParentView.indexOfChild(mCurrentView.getView());

        if (mParentView.getChildAt(indexOfView) != targetView) {
            mParentView.removeView(mCurrentView.getView());

            mParentView.addView(targetView.getView(), indexOfView, originParams);

            mCurrentView = targetView;
        }
    }

    @Override
    public void removeAllViews() {
        if (mCurrentView != mOriginView) {
            switchLayout(mOriginView);
        }

        mParentView = null;
        mCurrentView = null;
        originParams = null;
        mOriginView = null;
    }

    @NonNull
    @Override
    public IStatusView getCurrentStatusView() {
        return mCurrentView;
    }
}
