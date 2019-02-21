package qianxing.taojinke.ui.login;

import taojinke.qianxing.lib_base.base.BaseView;
import taojinke.qianxing.lib_kernel.model.LoginUserBean;


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

        void saveUserInfo(LoginUserBean bean);

        void refreshUI(boolean isOk);
    }

    interface ILoginPresenter {

        void loginTjk(String user, String password);

    }
}
