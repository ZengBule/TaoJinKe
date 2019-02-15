package qianxing.taojinke.ui.launcher;

import taojinke.qianxing.lib_base.base.BaseView;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.launcher
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2019/1/14+10:23
 * 修改人：
 * 修改时间：2019/1/14+10:23
 * 修改备注：
 * ***********************************************
 */
public interface LauncherContract {
    interface ILauncherView extends BaseView {
        void checkTokenCallback(String content);
    }

    interface ILauncherPresenter {
        void getAppVersionInfo();
    }
}
