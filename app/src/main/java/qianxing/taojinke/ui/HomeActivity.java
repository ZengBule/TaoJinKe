package qianxing.taojinke.ui;

import android.os.Bundle;

import qianxing.taojinke.R;
import qianxing.taojinke.base.DaggerActivity;
import qianxing.taojinke.dagger.activity.ActivityComponent;

import javax.inject.Inject;


public class HomeActivity extends DaggerActivity implements HomeContract.IHomeView {
    @Inject
    HomeContract.IHomePresenter mPresenter;

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_main;
    }
}
