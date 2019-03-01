package taojinke.qianxing.earlywarning.ui.executing;


import java.util.List;

import taojinke.qianxing.earlywarning.ui.executing.pw.two.AlarmContentData;
import taojinke.qianxing.earlywarning.ui.executing.store.StoreInfo;

public class WorkInfo {

    /**
     * serviceState : ReadyForService
     * serviceTime : 12345
     * forecastEarnings : 2000
     * shopList : []
     * warningMessages : []
     */
    private int tjkId;
    private String reason;
    private String serviceState;
    private boolean isPutOn;
    private int serviceTime;
    private double forecastEarnings;
    private int unConfirmedNumber;
    private List<StoreInfo> shopList;
    private List<AlarmContentData> warningMessages;

    public int getUnConfirmedNumber() {
        return unConfirmedNumber;
    }

    public void setUnConfirmedNumber(int unConfirmedNumber) {
        this.unConfirmedNumber = unConfirmedNumber;
    }

    public int getTjkId() {
        return tjkId;
    }

    public void setTjkId(int tjkId) {
        this.tjkId = tjkId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public boolean isPutOn() {
        return isPutOn;
    }

    public void setPutOn(boolean putOn) {
        isPutOn = putOn;
    }

    public double getForecastEarnings() {
        return forecastEarnings;
    }

    public void setForecastEarnings(double forecastEarnings) {
        this.forecastEarnings = forecastEarnings;
    }

    public List<StoreInfo> getShopList() {
        return shopList;
    }

    public void setShopList(List<StoreInfo> shopList) {
        this.shopList = shopList;
    }

    public List<AlarmContentData> getWarningMessages() {
        return warningMessages;
    }

    public void setWarningMessages(List<AlarmContentData> warningMessages) {
        this.warningMessages = warningMessages;
    }
}
