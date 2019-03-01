package taojinke.qianxing.earlywarning.ui.rule.vb.rule;

import java.util.List;

import taojinke.qianxing.earlywarning.ui.rule.vb.rule.cvb.RuleContent;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.taskstatus.alarmRuler.vb.report
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2018/12/19+14:53
 * 修改人：
 * 修改时间：2018/12/19+14:53
 * 修改备注：
 * ***********************************************
 */
public class RuleAndSpeak {

    /**
     * warningCardList : [{"handleItemList":[{"duration":"0-5","handleRule":"按平台服务手册6条规则处理"},{"duration":"6-10","handleRule":"按平台服务手册5条规则处理"}],"standard":"任务开启时候未打卡","title":"出勤"},{"handleItemList":[{"duration":"0-5","handleRule":"按平台服务手册6条规则处理"}],"standard":"下班后系统未检测到客服服务数据客服超过30分钟仍未打卡","title":"出勤"}]
     * illustrate : 平台所有预警，一旦出现将根据对应规则处罚，请大家自觉遵守服务手册规定。
     */

    private String illustrate;
    private List<WarningCardListBean> warningCardList;
    private Object reportCardList;

    public Object getReportCardList() {
        return reportCardList;
    }

    public void setReportCardList(Object reportCardList) {
        this.reportCardList = reportCardList;
    }

    public String getIllustrate() {
        return illustrate;
    }

    public void setIllustrate(String illustrate) {
        this.illustrate = illustrate;
    }

    public List<WarningCardListBean> getWarningCardList() {
        return warningCardList;
    }

    public void setWarningCardList(List<WarningCardListBean> warningCardList) {
        this.warningCardList = warningCardList;
    }

    public static class WarningCardListBean {
        /**
         * handleItemList : [{"duration":"0-5","handleRule":"按平台服务手册6条规则处理"},{"duration":"6-10","handleRule":"按平台服务手册5条规则处理"}]
         * standard : 任务开启时候未打卡
         * title : 出勤
         */

        private String standard;
        private String title;
        private List<RuleContent> handleItemList;

        public String getStandard() {
            return standard;
        }

        public void setStandard(String standard) {
            this.standard = standard;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<RuleContent> getHandleItemList() {
            return handleItemList;
        }

        public void setHandleItemList(List<RuleContent> handleItemList) {
            this.handleItemList = handleItemList;
        }

    }
}