package qianxing.taojinke.ui.main;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import qianxing.taojinke.R;
import qianxing.taojinke.base.DaggerActivity;
import qianxing.taojinke.dagger.activity.ActivityComponent;


public class MainActivity extends DaggerActivity implements MainContract.IMainView {
    @Inject
    MainContract.IMainPresenter mPresenter;

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
    }

    public native String stringFromJNI();

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_main;
    }

}
