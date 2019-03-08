package taojinke.qianxing.train.dagger.fragments;

public interface FragmentComponentInjects {
    void inject(taojinke.qianxing.train.ui.home.fragment.HomePresenter presenter);

    void inject(taojinke.qianxing.train.ui.home.fragment.HomeFragment fragment);

    void inject(taojinke.qianxing.train.ui.train.fragment.base.BaseTrainPresenter presenter);

    void inject(taojinke.qianxing.train.ui.train.fragment.base.BaseTrainFragment fragment);

    void inject(taojinke.qianxing.train.ui.train.fragment.task.TaskTrainPresenter presenter);

    void inject(taojinke.qianxing.train.ui.train.fragment.task.TaskTrainFragment fragment);

    void inject(taojinke.qianxing.train.ui.train.fragment.TrainPresenter presenter);

    void inject(taojinke.qianxing.train.ui.train.fragment.TrainFragment fragment);
}
