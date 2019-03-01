package taojinke.qianxing.earlywarning.ui.rule;

import me.drakeet.multitype.MultiTypeAdapter;
import taojinke.qianxing.lib_base.base.BaseView;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.earlywarning.ui.rule
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/1+16:27
 * 修改人：
 * 修改时间：2019/3/1+16:27
 * 修改备注：
 * ***********************************************
 */
public interface AlarmRulerAndSpeackContract {
    interface IAlarmRulerAndSpeackView extends BaseView {

    }

    interface IAlarmRulerAndSpeackPresenter {
        /**
         * 报备规则与说明
         */
        void getAlarmRuleSpeak();

        /**
         * 服务报备
         */
        void getServiceReport();


        MultiTypeAdapter getAlarmRuleSpeakAdapter();

        MultiTypeAdapter getServiceReportAdapter();
    }
}
