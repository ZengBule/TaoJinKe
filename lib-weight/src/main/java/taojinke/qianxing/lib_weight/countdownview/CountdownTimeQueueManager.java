package taojinke.qianxing.lib_weight.countdownview;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class CountdownTimeQueueManager extends BaseCountdownTimeQueueManager {
    public static CountdownTimeQueueManager manager;

    private CountdownTimeQueueManager() {
    }

    public static CountdownTimeQueueManager getInstance() {
        return manager;
    }

    public static CountdownTimeQueueManager getInstance(int modules) {
        manager = new CountdownTimeQueueManager();
        manager.initCountdownTimeQueueManager(modules);
        return manager;
    }

    @Override
    void initCountdownTimeQueueManager(int modules) {
        timeQueue = new ArrayList<>();
        timeTimer = new Timer(true);
        if (timeTask!=null){
            timeTask.cancel();
        }
        timeTask = new TimerTask() {
            @Override
            public void run() {
                switch (modules) {
                    case 1:
                        countdownTimeQueue();
                        break;
                    case 2:
                        countupTimeQueue();
                        break;
                }
            }
        };
        timeTimer.schedule(timeTask, 1000, 1000);
    }

    @Override
    public CountdownTime addTime(int time, String id, CountdownTime.OnCountdownTimeListener listener) {
        CountdownTime countdownTime;
        if (timeQueue.size() > 0)
            for (int i = 0; i < timeQueue.size(); i++) {
                countdownTime = timeQueue.get(i);
                if (TextUtils.equals(countdownTime.getId(), id)) {
                    countdownTime.setListener(listener);
                    return countdownTime;
                }
            }
        countdownTime = new CountdownTime(time, id, listener);
        timeQueue.add(countdownTime);
        return countdownTime;
    }

    @Override
    synchronized void countdownTimeQueue() {
        if (timeQueue != null && timeQueue.size() > 0) {
            for (int i = 0; i < timeQueue.size(); i++) {
                if (timeQueue.get(i).countdown())
                    i--;
            }
        }
    }

    @Override
    synchronized void countupTimeQueue() {
        if (timeQueue != null && timeQueue.size() > 0) {
            for (int i = 0; i < timeQueue.size(); i++) {
                if (timeQueue.get(i).countUp())
                    i++;
            }
        }
    }
}
