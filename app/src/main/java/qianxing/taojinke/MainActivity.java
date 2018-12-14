package qianxing.taojinke;


import android.app.Activity;
import android.os.Bundle;

import qianxing.taojinke.base.DaggerActivity;
import qianxing.taojinke.dagger.activity.ActivityComponent;


/**
 * @author Administrator
 */
public class MainActivity extends DaggerActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    @Override
    protected void trySetupData(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutResources() {
        return 0;
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    protected void inject(ActivityComponent activityComponent) {

    }
}
