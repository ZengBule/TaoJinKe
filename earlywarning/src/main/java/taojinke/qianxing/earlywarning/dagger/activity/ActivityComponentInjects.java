package taojinke.qianxing.earlywarning.dagger.activity;


public interface ActivityComponentInjects {

    void inject(taojinke.qianxing.earlywarning.ui.TaskEcecuterPresenter presenter);

    void inject(taojinke.qianxing.earlywarning.ui.TaskEcecuterActivity activity);

    void inject(taojinke.qianxing.earlywarning.ui.clazz.TaskWaitCompletPresenter presenter);

    void inject(taojinke.qianxing.earlywarning.ui.clazz.TaskWaitCompletActivity activity);

    void inject(taojinke.qianxing.earlywarning.ui.alarm.AlarmPresenter presenter);

    void inject(taojinke.qianxing.earlywarning.ui.alarm.AlarmActivity activity);

    void inject(taojinke.qianxing.earlywarning.ui.rule.AlarmRulerAndSpeackPresenter presenter);

    void inject(taojinke.qianxing.earlywarning.ui.rule.AlarmRulerAndSpeackActivity activity);
}
