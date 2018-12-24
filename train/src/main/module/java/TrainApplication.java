import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class TrainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
    }
}
