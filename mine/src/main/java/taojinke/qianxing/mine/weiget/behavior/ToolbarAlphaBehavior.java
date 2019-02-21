package taojinke.qianxing.mine.weiget.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import taojinke.qianxing.lib_kernel.http.net.rx.databus.RxBus;
import taojinke.qianxing.mine.R;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.widget.behavior
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2019/1/9+14:51
 * 修改人：
 * 修改时间：2019/1/9+14:51
 * 修改备注：
 * ***********************************************
 */
public class ToolbarAlphaBehavior extends CoordinatorLayout.Behavior<Toolbar> {
    private static final String TAG = "ToolbarAlphaBehavior";
    private int offset = 0;
    private int startOffset = 0;
    private int endOffset = 0;
    private Context context;

    public ToolbarAlphaBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }


    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, Toolbar toolbar, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        startOffset = 0;
        endOffset = context.getResources().getDimensionPixelOffset(R.dimen.x_ui_px_300_0) - toolbar.getHeight();
        offset += dyConsumed;
        Log.v("link", "offset===========" + offset + "endOffset=============" + endOffset);
        if (offset < endOffset && dyConsumed == 0) {
            offset = 0;
        }

        if (offset <= startOffset || offset < 50) {  //alpha为0
            toolbar.getBackground().setAlpha(0);
            ToolbarEvent event = new ToolbarEvent();
            event.isVisiti = false;
            RxBus.getInstance().send(event);

        } else if (offset > startOffset && offset < endOffset) { //alpha为0到255
            float precent = (float) (offset - startOffset) / endOffset;
            int alpha = Math.round(precent * 255);
            toolbar.getBackground().setAlpha(alpha);
            ToolbarEvent event = new ToolbarEvent();
            event.isVisiti = true;
            event.intAlpha = alpha;
            RxBus.getInstance().send(event);

        } else if (offset >= endOffset) {  //alpha为255
            toolbar.getBackground().setAlpha(255);
            ToolbarEvent event = new ToolbarEvent();
            event.isVisiti = true;
            event.intAlpha = 255;
            RxBus.getInstance().send(event);
        }
    }

    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {

        if (offset < endOffset && velocityY == 0) {
            offset = 0;
        }
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);

    }
}