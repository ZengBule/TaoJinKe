package taojinke.qianxing.lib_weight;

import android.content.Context;

import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class DispatchEventRecyclerView extends RecyclerView {
    public DispatchEventRecyclerView(Context context) {
        super(context);
    }

    public DispatchEventRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchEventRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return false;
    }
}
