package taojinke.qianxing.lib_base.base;


import android.content.Context;
import android.content.Intent;

import com.trello.rxlifecycle2.components.support.RxFragment;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BaseFragment extends RxFragment implements BaseView {
    @Override
    public void showToast(String message) {

    }

    @Override
    public void showToast(int message) {

    }

    @Override
    public Context fetchContext() {
        return null;
    }

    @Override
    public Intent fetchIntent() {
        return null;
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
        return bindToLifecycle();
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
