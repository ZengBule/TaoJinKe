package taojinke.qianxing.lib_weight.countdownview;

import android.util.Log;

/**
 * Created by zhaocheng on 2017/3/27.
 */

public class CountdownTime extends BaseCountdownTime {
    private int seconds;
    private String id;
    private OnCountdownTimeListener listener;

    public void setListener(OnCountdownTimeListener listener) {
        this.listener = listener;
    }

    public CountdownTime(int time, String id, OnCountdownTimeListener listener) {
        this.seconds = time;
        this.id = id;
        this.listener = listener;
    }

    public String getId() {
        return id;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public boolean countdown() {
        seconds -= 1;
        if (seconds == 0) {
            if (onTimeCountdownOverListener != null) {
                Log.d("Blin CountdownOver", "倒计时结束id:" + id);
                onTimeCountdownOverListener.onTimeCountdownOver();
            }
            CountdownTimeQueueManager.getInstance().removeTime(this);
            listener.onCountdownTimeDraw(this);
            return true;
        } else if (seconds < 0) {
            CountdownTimeQueueManager.getInstance().removeTime(this);
            listener.onCountdownTimeDraw(this);
            return true;
        }
        listener.onCountdownTimeDraw(this);
        return false;
    }

    public boolean countUp() {
        seconds += 1;
        if (seconds == 0) {
            if (onTimeCountdownOverListener != null) {
                Log.d("Blin CountdownOver", "倒计时结束id:" + id);
                onTimeCountdownOverListener.onTimeCountdownOver();
            }
            CountdownTimeQueueManager.getInstance().removeTime(this);
            listener.onCountdownTimeDraw(this);
            return true;
        } else if (seconds < 0) {
            CountdownTimeQueueManager.getInstance().removeTime(this);
            listener.onCountdownTimeDraw(this);
            return true;
        }
        listener.onCountdownTimeDraw(this);
        return false;
    }

    @Override
    String getTimeTextTypeOne() {
        String text;
        if (seconds >= 0) {
            if (seconds > 3600) {
                hour = seconds / 3600;
                if (seconds / 3600 > 0) {
                    minute = seconds % 3600 / 60;
                    second = seconds % 3600 % 60;
                } else {
                    minute = 0;
                    seconds = seconds % 3600;
                }
            } else {
                hour = 0;
                minute = seconds / 60;
                second = seconds % 60;
            }
        } else {
            return "00:00";
        }
        if (hour == 0) {
            if (minute < 10) {
                text = "0" + minute;
                if (second < 10) {
                    text += ":0" + second;
                } else {
                    text += ":" + second;
                }
            } else {
                text = "" + minute;
                if (second < 10) {
                    text += ":0" + second;
                } else {
                    text += ":" + second;
                }
            }
            return text;
        } else {
            //这边当倒计时大于一个小时时没做处理，可以自己改
            return hour + ":" + minute + ":" + second;
        }
    }

    @Override
    String getTimeTextTypeTwo() {
        return seconds + "秒";
    }

    @Override
    String getTimeTextHm() {

        String text;
        if (seconds >= 0) {
            if (seconds > 3600) {
                hour = seconds / 3600;
                if (seconds / 3600 > 0) {
                    minute = seconds % 3600 / 60;
                    second = seconds % 3600 % 60;
                } else {
                    minute = 0;
                    seconds = seconds % 3600;
                }
            } else {
                hour = 0;
                minute = seconds / 60;
                second = seconds % 60;
            }
        } else {
            return "00min00s";
        }
        if (hour == 0) {
            if (minute < 10) {
                text = "0" + minute;
                if (second < 10) {
                    text += ":0" + second;
                } else {
                    text += ":" + second;
                }
            } else {
                text = "" + minute;
                if (second < 10) {
                    text += "min0" + second;
                } else {
                    text += "min" + second;
                }
            }
            return text;
        } else {
            //这边当倒计时大于一个小时时没做处理，可以自己改
            return hour + "h" + minute + "min" + second;
        }
    }

    @Override
    String getTimeText() {
        String text;
        if (seconds >= 0) {
            if (seconds > 60) {
                if (seconds / 60 > 0) {
                    minute = seconds / 60;
                    second = seconds % 60;
                } else {
                    minute = 0;
                    second = seconds;
                }
            } else {
                second = seconds;
            }
        } else {
            return "00分钟00秒";
        }
        if (minute > 0) {
            if (minute < 10) {
                text = "0" + minute + "分钟";
                if (second < 10) {
                    text += "0" + second + "秒";
                } else {
                    text += "" + second + "秒";
                }
            } else {
                text = "" + minute + "分钟";
                if (second < 10) {
                    text += "0" + second + "秒";
                } else {
                    text += "" + second + "秒";
                }
            }
            return text;
        }
        return minute + "分钟" + second + "秒";
    }

    interface OnCountdownTimeListener {
        void onCountdownTimeDraw(CountdownTime time);
    }

    public interface OnTimeCountdownOverListener {
        void onTimeCountdownOver();
    }

    /**
     * 这个真的不是我想这样做，没办法，item不展示的时候也要回调，那就索性简单粗暴点
     */
    public static OnTimeCountdownOverListener onTimeCountdownOverListener;
}
