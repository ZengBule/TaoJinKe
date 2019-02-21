package qianxing.taojinke.ui.user.verifycode;

import taojinke.qianxing.lib_base.base.BaseView;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.user.verifycode
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/18+16:47
 * 修改人：
 * 修改时间：2019/2/18+16:47
 * 修改备注：
 * ***********************************************
 */
public interface VerifyCodeContract {
    interface IVerifyCodeView extends BaseView {

    }

    interface IVerifyCodePresenter {
        void keyRegisterUser(String phone, String code);

        void keyUpdateBindPhone(String code);

        void keyBindNewPhone(String phone, String code);

        void keyUpdateLoginPassword(String phone, String code);


    }
}
