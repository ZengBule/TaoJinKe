package qianxing.taojinke.ui.user.register;

import taojinke.qianxing.lib_base.base.BaseView;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.user.register
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/18+18:06
 * 修改人：
 * 修改时间：2019/2/18+18:06
 * 修改备注：
 * ***********************************************
 */
public interface RegisterUserContract {
    interface IRegisterUserView extends BaseView {

        void goToIdentifyCodeActivity(String phoneNumber);
    }

    interface IRegisterUserPresenter {
        void sendRegisterSMS(String deviceId, String phoneNumber);
    }
}
