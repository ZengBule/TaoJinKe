package taojinke.qianxing.lib_base.base;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseFragment extends Fragment implements BaseView {

    private Unbinder mUnbinder;
    private BaseActivity mContext;

    public BaseActivity getmContext() {
        return mContext;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = (BaseActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflated = inflater.inflate(getLayoutResources(), container, false);
        mUnbinder = ButterKnife.bind(this, inflated);
        return inflated;
    }


    protected abstract int getLayoutResources();

    protected abstract void trySetupData(Bundle savedInstanceState);

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        trySetupData(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        mUnbinder = null;
    }


    @Override
    public void showToast(String message) {

    }

    @Override
    public void showToast(int message) {

    }

    @Override
    public Context fetchContext() {
        return mContext;
    }

    @Override
    public Intent fetchIntent() {
        return mContext.getIntent();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void finishActivity() {

    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return null;
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycleAndThread() {
        return upstream ->
                upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(bindLifecycle());
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycleAndThreadWithLoading() {
        return upstream ->
                upstream.subscribeOn(Schedulers.io())
                        .doOnSubscribe(disposable -> showLoading())
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnTerminate(this::dismissLoading)
                        .compose(bindLifecycle());
    }
}
