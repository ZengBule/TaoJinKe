package qianxing.taojinke.ui.login;

import taojinke.qianxing.lib_base.base.BaseView;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.login
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/15+14:44
 * 修改人：
 * 修改时间：2019/2/15+14:44
 * 修改备注：
 * ***********************************************
 */
public interface LoginContract {
    interface ILoginView extends BaseView {

    }

    interface ILoginPresenter {

        void loginTjk(String user, String password);

    }
}
