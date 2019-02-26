package taojinke.qianxing.lib_weight.countdownview;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by zhaocheng on 2017/3/27.
 */

public abstract class BaseCountdownTimeQueueManager {
    protected ArrayList<CountdownTime> timeQueue;
    protected Timer timeTimer;
    protected ScheduledExecutorService scheduledExecutorService;
    protected TimerTask timeTask;

    public Timer getTimeTimer() {
        return timeTimer;
    }

    public void removeTime(CountdownTime time) {
        if (timeQueue != null) {
            for (int i = 0; i < timeQueue.size(); i++) {
                if (i >= timeQueue.size() - 1) {
                    break;
                }
                if (TextUtils.equals(time.getId(), timeQueue.get(i).getId())) {

                    timeQueue.remove(i);
                }
            }
        }
    }

    abstract void countdownTimeQueue();

    abstract void initCountdownTimeQueueManager(int modules);

    public abstract CountdownTime addTime(int time, String id, CountdownTime.OnCountdownTimeListener listener);

    abstract void countupTimeQueue();
}
