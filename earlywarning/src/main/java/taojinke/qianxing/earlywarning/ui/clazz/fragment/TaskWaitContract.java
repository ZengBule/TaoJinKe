package taojinke.qianxing.earlywarning.ui.clazz.fragment;

import me.drakeet.multitype.MultiTypeAdapter;
import taojinke.qianxing.lib_base.base.BaseView;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.earlywarning.ui.clazz.fragment
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/1+15:37
 * 修改人：
 * 修改时间：2019/3/1+15:37
 * 修改备注：
 * ***********************************************
 */
public interface TaskWaitContract {
    interface ITaskWaitView extends BaseView {

        void showNormal();

        void showNoNetwork();

        void showError();

        void showEmpty();

        void stopRefresh();

        void getServiceHoursNum(String serviceHoursNum);
    }

    interface ITaskWaitPresenter {
        void tryLoadData();

        void getServiceHours();

        MultiTypeAdapter getAdapter();
    }
}
