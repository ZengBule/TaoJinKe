package taojinke.qianxing.task.dagger.activity;


public interface ActivityComponentInjects {

    void inject(taojinke.qianxing.task.ui.status.TaskExecutingPresenter presenter);

    void inject(taojinke.qianxing.task.ui.status.TaskExecutingActivity activity);
}
