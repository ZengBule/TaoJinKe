package taojinke.qianxing.train;


import com.alibaba.android.arouter.launcher.ARouter;

import taojinke.qianxing.lib_base.app.LifecycleApplication;

public class TrainApplication extends LifecycleApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
    }
}
