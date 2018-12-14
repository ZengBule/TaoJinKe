package qianxing.taojinke.app;


import android.content.Context;

import qianxing.taojinke.BuildConfig;
import qianxing.taojinke.TaoJinKeApplicationLike;
import taojinke.qianxing.lib_base.app.ApplicationLike;
import taojinke.qianxing.lib_base.app.LifecycleApplication;

/**
 * 主工程 唯一application 所有的模块的application 在此中统一初始化
 *
 * @author andy
 */
public class TaoJinkeApplication extends LifecycleApplication {

    private static Context mContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

    }

    @Override
    protected ApplicationLike[] getAllApplicationLikes() {
        return new ApplicationLike[]{
                new TaoJinKeApplicationLike()
        };
    }


    public static Context getContext() {
        return mContext;
    }


}
