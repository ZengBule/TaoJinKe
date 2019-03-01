package taojinke.qianxing.earlywarning.ui.rule.vb.report;

import java.util.List;

import qianxing.taojinke.ui.taskstatus.alarmRuler.vb.report.cvb.ServiceReportContent;

/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.taskstatus.alarmRuler.vb.report
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2018/12/19+15:19
 * 修改人：
 * 修改时间：2018/12/19+15:19
 * 修改备注：
 * ***********************************************
 */
public class ServiceReport {

    /**
     * reportCardList : [{"handleItemList":[{"duration":"0-5","handleRule":"按平台服务手册6条规则处理"},{"duration":"6-10","handleRule":"按平台服务手册5条规则处理"}],"standard":"任务开启时候未打卡","title":"出勤"},{"handleItemList":[{"duration":"0-5","handleRule":"按平台服务手册6条规则处理"}],"standard":"下班后系统未检测到客服服务数据客服超过30分钟仍未打卡","title":"出勤"}]
     * illustrate : 平台所有预警，一旦出现将根据对应规则处罚，请大家自觉遵守服务手册规定。
     */

    private String illustrate;
    private List<ReportCardListBean> reportCardList;
    private Object warningCardList;

    public Object getWarningCardList() {
        return warningCardList;
    }

    public void setWarningCardList(Object warningCardList) {
        this.warningCardList = warningCardList;
    }

    public String getIllustrate() {
        return illustrate;
    }

    public void setIllustrate(String illustrate) {
        this.illustrate = illustrate;
    }

    public List<ReportCardListBean> getReportCardList() {
        return reportCardList;
    }

    public void setReportCardList(List<ReportCardListBean> reportCardList) {
        this.reportCardList = reportCardList;
    }

    public static class ReportCardListBean {
        /**
         * handleItemList : [{"duration":"0-5","handleRule":"按平台服务手册6条规则处理"},{"duration":"6-10","handleRule":"按平台服务手册5条规则处理"}]
         * standard : 任务开启时候未打卡
         * title : 出勤
         */

        private String standard;
        private String title;
        private List<ServiceReportContent> handleItemList;

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

        public List<ServiceReportContent> getHandleItemList() {
            return handleItemList;
        }

        public void setHandleItemList(List<ServiceReportContent> handleItemList) {
            this.handleItemList = handleItemList;
        }

    }
}