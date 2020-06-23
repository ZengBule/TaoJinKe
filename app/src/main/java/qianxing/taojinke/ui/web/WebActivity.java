package qianxing.taojinke.ui.web;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.alibaba.fastjson.JSON;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import qianxing.taojinke.R;
import taojinke.qianxing.lib_base.base.BaseActivity;
import taojinke.qianxing.lib_kernel.http.net.rx.RxRestClient;

public class WebActivity extends BaseActivity {

    @BindView(R.id.web)
    WebView web;

    @Override
    protected void trySetupData(Bundle savedInstanceState) {


        String url = "http://niu.ni5t.cn/article/detail?id=D8EVbn8IODS.F8VDeS.d46033";
        RxRestClient.create()
                .url(url)
                .build()
                .postQuery()
                .compose(bindLifecycleAndThreadWithLoading())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {

                        DataBen baseBean = JSON.parseObject(s, DataBen.class);

                        web.loadData(baseBean.getData().getContent(),"text/html","utf-8");

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_web;
    }

}
