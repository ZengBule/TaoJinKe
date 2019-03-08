package taojinke.qianxing.mine.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import taojinke.qianxing.lib_base.app.LifecycleApplication;
import taojinke.qianxing.lib_base.base.BaseActivity;
import taojinke.qianxing.mine.app.MineApplicationLikeImpl;
import taojinke.qianxing.mine.dagger.ComponentFactory;
import taojinke.qianxing.mine.dagger.activity.ActivityComponent;


public abstract class DaggerActivity extends BaseActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        inject(getActivityComponent());
        super.onCreate(savedInstanceState);

    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = ComponentFactory.createActivityComponent(this,
                    getLifecycleApplication().fetchApplicationLike(MineApplicationLikeImpl.class));
        }
        return activityComponent;
    }

    private LifecycleApplication getLifecycleApplication() {
        return ((LifecycleApplication) getApplication());
    }

    protected abstract void inject(ActivityComponent activityComponent);

    public void lanuchActivity(Class<? extends BaseActivity> clazz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);

    }

    public void lanuchActivity(Class<? extends BaseActivity> clazz) {
        Intent intent = new Intent();
        intent.setClass(this, clazz);

        startActivity(intent);

    }
}
