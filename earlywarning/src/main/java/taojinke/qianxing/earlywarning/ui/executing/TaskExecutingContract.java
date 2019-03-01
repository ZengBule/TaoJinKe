package taojinke.qianxing.earlywarning.ui.executing;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import taojinke.qianxing.lib_base.base.BaseView;
import taojinke.qianxing.lib_weight.countdownview.CountdownView;
import taojinke.qianxing.lib_weight.pw.CommonPopupWindow;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.earlywarning.ui.executing
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/1+10:11
 * 修改人：
 * 修改时间：2019/3/1+10:11
 * 修改备注：
 * ***********************************************
 */
public interface TaskExecutingContract {
    interface ITaskExecutingView extends BaseView {
        void showNormal();

        void showNoNetwork();

        void showError();

        void showEmpty(String s);

        void stopRefresh();

        TextView getTaskStatus();

        TextView getLongTime();

        TextView getHintText();

        LinearLayout getServiceStatusLinearLayout();

        RelativeLayout getDriectIncomeLayout();

        TextView getIncomeTextView();

        TextView getCountAlarmTextView();

        CountdownView getCountdownView();

        void showBottomLayout(boolean isShow, String serviceState);
    }

    interface ITaskExecutingPresenter {
        void tryLoadData();

        MultiTypeAdapter getAdapter();

        CommonPopupWindow createPopupWindow();

        Items getAlarmData();
    }
}
