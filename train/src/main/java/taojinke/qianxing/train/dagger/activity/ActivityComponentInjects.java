package taojinke.qianxing.train.dagger.activity;

/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.dagger.activity
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2018/12/18+10:42
 * 修改人：
 * 修改时间：2018/12/18+10:42
 * 修改备注：
 * ***********************************************
 */

public interface ActivityComponentInjects {


    void inject(taojinke.qianxing.train.ui.main.MainPresenter presenter);

    void inject(taojinke.qianxing.train.ui.main.MainActivity activity);
}
