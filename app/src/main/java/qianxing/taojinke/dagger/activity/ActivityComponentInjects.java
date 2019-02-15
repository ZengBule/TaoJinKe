package qianxing.taojinke.dagger.activity;


public interface ActivityComponentInjects {

    void inject(qianxing.taojinke.ui.main.MainPresenter presenter);

    void inject(qianxing.taojinke.ui.main.MainActivity activity);

    void inject(qianxing.taojinke.ui.launcher.LauncherPresenter presenter);

    void inject(qianxing.taojinke.ui.launcher.LauncherActivity activity);

    void inject(qianxing.taojinke.ui.login.LoginPresenter presenter);

    void inject(qianxing.taojinke.ui.login.LoginActivity activity);
}
