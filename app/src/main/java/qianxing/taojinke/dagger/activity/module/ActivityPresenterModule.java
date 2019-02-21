package qianxing.taojinke.dagger.activity.module;

import dagger.Module;
import dagger.Provides;
import qianxing.taojinke.base.DaggerActivity;
import qianxing.taojinke.dagger.activity.ActivityComponent;
import taojinke.qianxing.lib_base.dagger.ActivityScope;

@Module
public class ActivityPresenterModule {
    private final DaggerActivity daggerActivity;

    public ActivityPresenterModule(DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    public ActivityComponent getActivityComponent() {
        return daggerActivity.getActivityComponent();
    }



    @Provides
    @ActivityScope
    qianxing.taojinke.ui.main.MainContract.IMainPresenter providerMainPresenter() {
        qianxing.taojinke.ui.main.MainPresenter presenter = new qianxing.taojinke.ui.main.MainPresenter();
        getActivityComponent().inject(presenter);
        return presenter;
    }

    @Provides
    @ActivityScope
    qianxing.taojinke.ui.launcher.LauncherContract.ILauncherPresenter providerLauncherPresenter() {
        qianxing.taojinke.ui.launcher.LauncherPresenter presenter = new qianxing.taojinke.ui.launcher.LauncherPresenter();
        getActivityComponent().inject(presenter);
        return presenter;
    }

    @Provides
    @ActivityScope
    qianxing.taojinke.ui.login.LoginContract.ILoginPresenter providerLoginPresenter() {
        qianxing.taojinke.ui.login.LoginPresenter presenter = new qianxing.taojinke.ui.login.LoginPresenter();
        getActivityComponent().inject(presenter);
        return presenter;
    }

    @Provides
    @ActivityScope
    qianxing.taojinke.ui.user.forgetpassword.ForgetPasswordContract.IForgetPasswordPresenter providerForgetPasswordPresenter() {
        qianxing.taojinke.ui.user.forgetpassword.ForgetPasswordPresenter presenter = new qianxing.taojinke.ui.user.forgetpassword.ForgetPasswordPresenter();
        getActivityComponent().inject(presenter);
        return presenter;
    }

    @Provides
    @ActivityScope
    qianxing.taojinke.ui.user.verifycode.VerifyCodeContract.IVerifyCodePresenter providerVerifyCodePresenter() {
        qianxing.taojinke.ui.user.verifycode.VerifyCodePresenter presenter = new qianxing.taojinke.ui.user.verifycode.VerifyCodePresenter();
        getActivityComponent().inject(presenter);
        return presenter;
    }

    @Provides
    @ActivityScope
    qianxing.taojinke.ui.user.register.RegisterUserContract.IRegisterUserPresenter providerRegisterUserPresenter() {
        qianxing.taojinke.ui.user.register.RegisterUserPresenter presenter = new qianxing.taojinke.ui.user.register.RegisterUserPresenter();
        getActivityComponent().inject(presenter);
        return presenter;
    }
}
