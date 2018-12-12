package taojinke.qianxing.lib_base.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author Administrator
 */
public abstract class BaseActivity extends RxAppCompatActivity implements BaseView {

    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getContentViewLayoutId());
        unbinder = ButterKnife.bind(this);
        initInject();
        init(savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        unbinder = null;
    }

    public int getContentViewLayoutId() {
        return 0;
    }

    /**
     * dagger注入
     */
    public void initInject() {

    }

    /**
     * 进行初始化操作
     */
    public void init(Bundle savedInstanceState) {
    }

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
