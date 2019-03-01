package taojinke.qianxing.earlywarning.dagger.fragment;



public interface FragmentComponentInjects {


    void inject(taojinke.qianxing.earlywarning.ui.executing.TaskExecutingPresenter presenter);

    void inject(taojinke.qianxing.earlywarning.ui.executing.TaskExecutingFragment fragment);

    void inject(taojinke.qianxing.earlywarning.ui.clazz.fragment.TaskWaitPresenter presenter);

    void inject(taojinke.qianxing.earlywarning.ui.clazz.fragment.TaskWaitFragment fragment);
}
