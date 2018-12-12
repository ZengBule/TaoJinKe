package taojinke.qianxing.lib_weight.loading.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import taojinke.qianxing.lib_weight.R;
import taojinke.qianxing.lib_weight.loading.callback.OnRetryClickListener;


/**
 * Created by Administrator on 2017/11/8.
 */

public class EmptyStatusView implements IStatusView {

    private Context context;
    private OnRetryClickListener mListener;

    private View emptyView;
    private TextView messageView;
    private ImageView iv_icon;
    private int tag;

    public EmptyStatusView(Context context, OnRetryClickListener listener) {
        this.context = context;
        this.mListener = listener;

        emptyView = LayoutInflater.from(context).inflate(R.layout.layout_empty, null, false);
        messageView = emptyView.findViewById(R.id.tv_message);
        iv_icon = emptyView.findViewById(R.id.iv_icon);
        emptyView.findViewById(R.id.btn_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onRetry(view);
                }
            }
        });
    }

    @Override
    public View getView() {
        return emptyView;
    }

    @Override
    public void setTag(int tag) {
        this.tag = tag;

    }

    @Override
    public int getTag() {
        return tag;
    }

    @Override
    public void setMessage(String message) {
        if (message != null) {
            messageView.setText(message);
        }
    }

    @Override
    public void setButtonText(String button) {

    }

    @Override
    public void setStatusImage(int resId) {
        if (iv_icon != null) {
            iv_icon.setImageResource(resId);
        }
    }

    @Override
    public void startAnimation() {

    }

    @Override
    public void stopAnimation() {

    }

    @Override
    public void destroy() {

    }
}
