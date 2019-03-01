package taojinke.qianxing.earlywarning.ui.executing.store;

public class StoreInfo {


    private String id;

    /**
     * orderId : 7483.0
     * shopName : 淘金客平台1611
     * shopHead : http://img.zcool.cn/community/0142135541fe180000019ae9b8cf86.jpg@1280w_1l_2o_100sh.png
     * shopState : InService
     * earning : 900.0
     * startTime : 2018-12-03 19:00:00
     * endTime : 2018-12-03 22:00:00
     * schedulingTime : 19:00 - 22:00
     * remainingSchedulingTime : 9319.0
     * hourlyPay : 30.0
     */

    private double orderId;
    private String shopName;
    private String shopHead;
    private String shopState;
    private double earning;
    private String startTime;
    private String endTime;
    private String schedulingTime;
    private double remainingSchedulingTime;
    private double hourlyPay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getOrderId() {
        return orderId;
    }

    public void setOrderId(double orderId) {
        this.orderId = orderId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopHead() {
        return shopHead;
    }

    public void setShopHead(String shopHead) {
        this.shopHead = shopHead;
    }

    public String getShopState() {
        return shopState;
    }

    public void setShopState(String shopState) {
        this.shopState = shopState;
    }

    public double getEarning() {
        return earning;
    }

    public void setEarning(double earning) {
        this.earning = earning;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSchedulingTime() {
        return schedulingTime;
    }

    public void setSchedulingTime(String schedulingTime) {
        this.schedulingTime = schedulingTime;
    }

    public double getRemainingSchedulingTime() {
        return remainingSchedulingTime;
    }

    public void setRemainingSchedulingTime(double remainingSchedulingTime) {
        this.remainingSchedulingTime = remainingSchedulingTime;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }
}