package taojinke.qianxing.lib_weight;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class AtMostRecyclerView extends RecyclerView {


    public AtMostRecyclerView(Context context) {
        super(context);
    }

    public AtMostRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AtMostRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, expandSpec);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return false;
    }
}
