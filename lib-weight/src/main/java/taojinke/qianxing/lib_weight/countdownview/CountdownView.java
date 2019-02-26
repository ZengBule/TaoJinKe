package taojinke.qianxing.lib_weight.countdownview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;

import java.lang.ref.WeakReference;

import qianxing.taojinke.R;


public class CountdownView extends android.support.v7.widget.AppCompatTextView implements CountdownTime.OnCountdownTimeListener {
    /**
     * 当前控件绑定的倒计时实践对象id，由于重用，RecyclerView滚动的时候，
     * 会复用view，导致里面显示的时间其实是不一样的
     */
    private String nowId;
    private CountdownTimeQueueManager manager;
    private CountdownTime countdownTime;
    private int TEXT_COLOR = 0xFF757575;
    private Paint textPaint;

    public CountdownTimeQueueManager getManager() {
        return manager;
    }

    public void setManager(CountdownTimeQueueManager manager) {
        this.manager = manager;
    }

    private String format = "H_M_S";

    /**
     * 时间显示格式
     */
    public enum TYPE {
        H_M_S,//00:00:00
        ONLY_S_C,//9000秒
        M_S_C,//0分钟0秒
    }

    public CountdownView setTimeFormat(TYPE type) {
        this.format = type.name();
        return this;
    }

    /**
     * @param modules==1 倒计时，2 顺计时
     */
    public void setModules(int modules) {
        this.modules = modules;
        manager = CountdownTimeQueueManager.getInstance(modules);
    }


    private int modules = 1;

    public CountdownView(Context context) {
        this(context, null);
    }

    public CountdownView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountdownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CountdownView, defStyleAttr, 0);
        modules = a.getInteger(R.styleable.CountdownView_modules, 1);

        init();
    }

    private void init() {
        textPaint = getPaint();
        textPaint.setTextSize(this.getTextSize());
        textPaint.setColor(getCurrentTextColor());
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setStrokeWidth(1);
        manager = CountdownTimeQueueManager.getInstance(modules);
    }

    private void drawText(Canvas canvas) {
        String testString = null;
        if (countdownTime == null) {
            testString = "0分钟0秒";
        } else {
            switch (format) {
                case "H_M_S":
                    testString = countdownTime.getTimeTextTypeOne();
                    break;
                case "M_S_C":
                    testString = countdownTime.getTimeText();
                    break;
                case "ONLY_S_C":
                    testString = countdownTime.getTimeTextTypeTwo();
                    break;
            }

        }
        Rect bounds = new Rect();
        textPaint.getTextBounds(testString, 0, testString.length(), bounds);
        Paint.FontMetricsInt fontMetrics = textPaint.getFontMetricsInt();
        int baseline = (getMeasuredHeight() - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        canvas.drawText(testString, getMeasuredWidth() / 2 - bounds.width() / 2, baseline, textPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawText(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int origin) {
        int result = (int) textPaint.measureText("99999分钟60秒");
        int specMode = MeasureSpec.getMode(origin);
        int specSize = MeasureSpec.getSize(origin);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    /**
     * 这边比较粗暴，哈哈哈
     */
    private int measureHeight(int origin) {
        int result = (int) textPaint.measureText("00");
        int specMode = MeasureSpec.getMode(origin);
        int specSize = MeasureSpec.getSize(origin);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    @Override
    public void onCountdownTimeDraw(CountdownTime time) {
        if (TextUtils.equals(nowId, time.getId())) {
            countdownTime = time;
            postInvalidate();
        }
    }

    /**
     * 多了一个id参数，实际应用中可以是订单id、流水id之类，可以保证唯一性即可
     */
    public void setCountdownTime(int time, String id, boolean start) {
        nowId = id;

        if (start) {
            if (time <= 0) {
                if (countdownTime != null) {
                    countdownTime.setSeconds(0);
                }
            } else {
                WeakReference<CountdownView> weakReference = new WeakReference<>(this);
                countdownTime = manager.addTime(time, id, weakReference.get());
            }

        } else {
            if (countdownTime != null) {
                countdownTime.setSeconds(time);
            }
        }
        postInvalidate();

    }

    public int getSeconds() {

        return countdownTime.getSeconds();
    }
}
