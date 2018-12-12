package qianxing.taojinke;


import taojinke.qianxing.lib_base.base.BaseActivity;

/**
 * @author Administrator
 */
public class MainActivity extends BaseActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }



    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
