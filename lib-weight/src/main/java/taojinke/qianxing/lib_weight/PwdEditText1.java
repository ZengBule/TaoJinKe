package taojinke.qianxing.lib_weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 *
 * 自定义密码输入框
 */
public class PwdEditText1 extends android.support.v7.widget.AppCompatEditText {

    /**
     * 间隔
     */
    private  int PWD_SPACING = 30;
    /**
     * 密码大小
     */
    private final int PWD_SIZE = 10;
    /**
     * 密码长度
     */
    private final int PWD_LENGTH = 6;
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * 宽度
     */
    private int mWidth;
    /**
     * 高度
     */
    private int mHeight;
    /**
     * 密码框
     */
    private Rect mRect;

    /**
     * 密码画笔
     */
    private Paint mPwdPaint;

    /**
     * 密码框画笔
     */
    private Paint mRectPaint;
    /**
     * 输入的密码长度
     */
    private int mInputLength;

    /**
     * 输入结束监听
     */
    private OnInputFinishListener mOnInputFinishListener;

    /**
     * 构造方法
     *
     * @param context
     * @param attrs
     */

    int textColor;
    float textSize;

    float stokeSize;
    int stokeColor;
    float connerRadius;
    public PwdEditText1(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.PwdEditText1);
        textColor = array.getColor(R.styleable.PwdEditText1_pwdColor,Color.parseColor("#2a2a2a"));
        textSize =  array.getDimension(R.styleable.PwdEditText1_pwdSize,70);
        stokeSize = array.getDimension(R.styleable.PwdEditText1_stokeSize,2);
        stokeColor = array.getColor(R.styleable.PwdEditText1_stokeColor,Color.parseColor("#bebebe"));
        connerRadius = array.getDimension(R.styleable.PwdEditText1_connerRadius,10);
        PWD_SPACING = (int) array.getDimension(R.styleable.PwdEditText1_pwdSpace,30);
        array.recycle();

        // 初始化密码画笔
        mPwdPaint = new Paint();
        mPwdPaint.setColor(textColor);
        mPwdPaint.setStyle(Paint.Style.FILL);
        mPwdPaint.setAntiAlias(true);
        mPwdPaint.setTextSize(textSize);

        // 初始化密码框
        mRectPaint = new Paint();
        mRectPaint.setStyle(Paint.Style.STROKE);
        mRectPaint.setStrokeWidth(stokeSize);
        mRectPaint.setColor(stokeColor);
        mRectPaint.setAntiAlias(true);
    }
    String text;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mWidth = getWidth();
        mHeight = getHeight();

        // 这三行代码非常关键，大家可以注释点在看看效果
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawRoundRect(new RectF(0, 0, mWidth, mHeight),10,10, paint);


//        // 计算每个密码框宽度
        int rectWidth = (mWidth - PWD_SPACING * (PWD_LENGTH - 1)) / PWD_LENGTH;

        // 绘制密码框
        for (int i = 0; i < PWD_LENGTH; i++) {
            int left = (rectWidth + PWD_SPACING) * i;
            int top = 2;
            int right = left + rectWidth;
            int bottom = mHeight - top;
            mRect = new Rect(left, top, right, bottom);
            canvas.drawRoundRect(new RectF(mRect),10,10, mRectPaint);
        }



        // 绘制密码
        for (int i = 0; i < mInputLength; i++) {
            int cx = rectWidth / 2 + (rectWidth + PWD_SPACING) * i;
            int cy = mHeight / 2;
            canvas.drawText(text,i,i+1,cx-25, cy+40, mPwdPaint);
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start,
                                 int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        this.mInputLength = text.toString().length();
        this.text = text.toString();
        invalidate();
        if (mInputLength == PWD_LENGTH && mOnInputFinishListener != null) {
            mOnInputFinishListener.onInputFinish(text.toString());
        }
    }

    public interface OnInputFinishListener {
        /**
         * 密码输入结束监听
         *
         * @param password
         */
        void onInputFinish(String password);
    }

    /**
     * 设置输入完成监听
     *
     * @param onInputFinishListener
     */
    public void setOnInputFinishListener(
            OnInputFinishListener onInputFinishListener) {
        this.mOnInputFinishListener = onInputFinishListener;
    }

}

