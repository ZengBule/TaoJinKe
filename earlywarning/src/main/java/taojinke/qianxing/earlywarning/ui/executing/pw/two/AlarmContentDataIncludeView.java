package taojinke.qianxing.earlywarning.ui.executing.pw.two;


import taojinke.qianxing.lib_weight.countdownview.CountdownView;

/**
 * 预警未处理数据
 */
public class AlarmContentDataIncludeView {
    /**
     * shopName : 千行你我话费专营店
     * warningAbstract : 等待上班打卡
     * warningState : 已报警
     * duration : 2000
     */
    private AlarmContentData data;
    private CountdownView countdownView;

    public AlarmContentData getData() {
        return data;
    }

    public void setData(AlarmContentData data) {
        this.data = data;
    }

    public CountdownView getCountdownView() {
        return countdownView;
    }

    public void setCountdownView(CountdownView countdownView) {
        this.countdownView = countdownView;
    }

}