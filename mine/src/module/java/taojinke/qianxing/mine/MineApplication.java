package taojinke.qianxing.mine;


import android.content.Context;

import taojinke.qianxing.lib_base.app.ApplicationLike;
import taojinke.qianxing.lib_base.app.LifecycleApplication;
import taojinke.qianxing.lib_kernel.http.app.Configurator;
import taojinke.qianxing.lib_kernel.url.BaseUrlManger;
import taojinke.qianxing.mine.app.MineApplicationLikeImpl;

public class MineApplication extends LifecycleApplication {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Configurator.getInstance().withApiHost(BaseUrlManger.setBaseUrl(this)).configure();
    }

    @Override
    protected ApplicationLike[] getAllApplicationLikes() {
        return new ApplicationLike[]{
                new MineApplicationLikeImpl()
        };
    }
}
