package taojinke.qianxing.lib_base.base;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.nekocode.rxlifecycle.RxLifecycle;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import taojinke.qianxing.lib_weight.DialogUtils;


/**
 * @author Administrator
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResources());
        unbinder = ButterKnife.bind(this);
        trySetupData(savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        unbinder = null;
    }

    protected abstract void trySetupData(Bundle savedInstanceState);

    protected abstract int getLayoutResources();

    /**
     * 进行初始化操作
     */

    @Override
    public void showToast(String message) {

    }

    @Override
    public void showToast(int message) {

    }

    @Override
    public Context fetchContext() {
        return this;
    }

    @Override
    public Intent fetchIntent() {
        return getIntent();
    }

    Dialog mDialog;

    @Override
    public void showLoading() {
        mDialog = DialogUtils.createLoadingDialog(this, null);
        if (mDialog != null) {
            mDialog.show();
        }
    }

    @Override
    public void dismissLoading() {
        if (mDialog != null) {
            mDialog.cancel();
        }
    }

    @Override
    public void finishActivity() {

    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return RxLifecycle.bind(this).withObservable();
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
