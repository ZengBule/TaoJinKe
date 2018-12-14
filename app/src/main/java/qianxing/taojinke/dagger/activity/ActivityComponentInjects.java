package qianxing.taojinke.dagger.activity;


public interface ActivityComponentInjects {

    void inject(qianxing.taojinke.ui.HomePresenter presenter);

    void inject(qianxing.taojinke.ui.HomeActivity activity);

    void inject(qianxing.taojinke.ui.main.MainPresenter presenter);

    void inject(qianxing.taojinke.ui.main.MainActivity activity);
}
