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


    void inject(taojinke.qianxing.train.ui.train.fragment.base.first.FirstIntoTrainPresenter presenter);

    void inject(taojinke.qianxing.train.ui.train.fragment.base.first.FirstIntoTrainFragment fragment);

    void inject(taojinke.qianxing.train.ui.train.fragment.base.clazz.TrainClassPresenter presenter);

    void inject(taojinke.qianxing.train.ui.train.fragment.base.clazz.TrainClassFragment fragment);

    void inject(taojinke.qianxing.train.ui.train.fragment.base.mojor.ChoseMojorPresenter presenter);

    void inject(taojinke.qianxing.train.ui.train.fragment.base.mojor.ChoseMojorFragment fragment);
}
