package taojinke.qianxing.earlywarning.ui.rule.vb.report.cvb;

/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.taskstatus.alarmRuler.vb.report.cvb
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2018/12/19+16:14
 * 修改人：
 * 修改时间：2018/12/19+16:14
 * 修改备注：
 * ***********************************************
 */
public class ServiceReportContent {
    /**
     * duration : 0-5
     * handleRule : 按平台服务手册6条规则处理
     */

    private String duration;
    private String handleRule;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getHandleRule() {
        return handleRule;
    }

    public void setHandleRule(String handleRule) {
        this.handleRule = handleRule;
    }
}