package taojinke.qianxing.train.ui.train.fragment.base.mojor;

import me.drakeet.multitype.MultiTypeAdapter;
import taojinke.qianxing.lib_base.base.BaseView;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.ui.train.fragment.base.mojor
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/12+17:51
 * 修改人：
 * 修改时间：2019/3/12+17:51
 * 修改备注：
 * ***********************************************
 */
public interface ChoseMojorContract {
    interface IChoseMojorView extends BaseView {
        void showNormal();

        void showNoNetwork();

        void showError();

        void showEmpty();

        void stopRefresh();
    }

    interface IChoseMojorPresenter {
        void getMajorData();

        MultiTypeAdapter getAdapter();
    }
}
