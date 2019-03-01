package taojinke.qianxing.earlywarning.ui.executing.pw.two;

/**
 * 预警未处理数据
 */
public class AlarmContentData {


    /**
     * shopId : 1611.0
     * shopName : 淘金客平台1611
     * warningAbstract : 擅自中断任务
     * warningState : 已预警
     * duration : 1.543818695E12
     */

    private double shopId;
    private String shopName;
    private String warningAbstract;
    private String warningState;
    private double duration;

    public double getShopId() {
        return shopId;
    }

    public void setShopId(double shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getWarningAbstract() {
        return warningAbstract;
    }

    public void setWarningAbstract(String warningAbstract) {
        this.warningAbstract = warningAbstract;
    }

    public String getWarningState() {
        return warningState;
    }

    public void setWarningState(String warningState) {
        this.warningState = warningState;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}