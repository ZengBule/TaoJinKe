package taojinke.qianxing.lib_weight.countdownview;

/**
 * Created by zhaocheng on 2017/3/27.
 */

public abstract class BaseCountdownTime {
    protected int hour;
    protected int minute;
    protected int second;

    abstract String getTimeTextHm();

    abstract String getTimeText();

    abstract String getTimeTextTypeOne();

    abstract String getTimeTextTypeTwo();

}
