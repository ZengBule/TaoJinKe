package taojinke.qianxing.lib_weight.loading.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import taojinke.qianxing.lib_weight.R;
import taojinke.qianxing.lib_weight.loading.callback.OnRetryClickListener;


/**
 * Created by Administrator on 2017/11/8.
 */

public class ErrorStatusView implements IStatusView {

    private Context context;
    private OnRetryClickListener mListener;

    private View errorView;
    private TextView messageView;
    private int tag;
    private ImageView iv_icon;
    private Button btn_retry;

    public ErrorStatusView(Context context, OnRetryClickListener listener) {
        this.context = context;
        this.mListener = listener;

        errorView = LayoutInflater.from(context).inflate(R.layout.layout_error, null, false);
        messageView = errorView.findViewById(R.id.tv_message);
        iv_icon = errorView.findViewById(R.id.iv_icon);
        btn_retry = errorView.findViewById(R.id.btn_retry);
        errorView.findViewById(R.id.btn_retry).setOnClickListener(new View.OnClickListener() {
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
        return errorView;
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
        if (!TextUtils.isEmpty(button)) {
            btn_retry.setText(button);
        }
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
