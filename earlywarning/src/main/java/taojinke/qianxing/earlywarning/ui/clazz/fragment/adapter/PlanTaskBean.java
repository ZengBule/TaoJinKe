package taojinke.qianxing.earlywarning.ui.clazz.fragment.adapter;

/**
 * Created by cc on 2018/5/29.
 */

public class PlanTaskBean {


    /**
     * taskId
     * shopName : 寒star女装精品店
     * workTimeStr : 00:00 - 次日00:00
     * missionState : Mission
     * shopIconUrl : http://wx.qlogo.cn/mmopen/uHbC1X24oBeLQZ7BNwiaz66H1N5a1SMaDDjsichkhCeANibStv8ADGY16FuZEMVbIBzJibfibNEZ7SWW5zEAyxCPFlNZaeBZ4eliaic/0
     * startTime :"2018-05-30 00:00:00"
     */
//    {
//        "isShowDate": false,
//            "isShowTitle": false,
//            "missionState": "Mission",
//            "shopIconUrl": "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516774314402&di=ae154ba846838cff1450dcf9bccdf588&imgtype=0&src=http://pic36.nipic.com/20131130/4499633_223342288000_2.jpg",
//            "shopName": "四川德成佳际实业有限公司",
//            "startTime": "2018-11-30 00:00:00",
//            "workTimeStr": "11月30日 00:00 - 12月02日 00:00"
//    }

    private String shopName;
    private String workTimeStr;
    private String missionState;
    private String shopIconUrl;
    private String taskId;
    private String startTime;
    private boolean isShowDate;
    private boolean isShowTitle;
    double hourlyPay;

    public boolean isShowTitle() {
        return isShowTitle;
    }

    public void setShowTitle(boolean showTitle) {
        isShowTitle = showTitle;
    }

    public boolean isShowDate() {
        return isShowDate;
    }

    public void setShowDate(boolean showDate) {
        isShowDate = showDate;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getWorkTimeStr() {
        return workTimeStr;
    }

    public void setWorkTimeStr(String workTimeStr) {
        this.workTimeStr = workTimeStr;
    }

    public String getMissionState() {
        return missionState;
    }

    public void setMissionState(String missionState) {
        this.missionState = missionState;
    }

    public String getShopIconUrl() {
        return shopIconUrl;
    }

    public void setShopIconUrl(String shopIconUrl) {
        this.shopIconUrl = shopIconUrl;
    }
}
