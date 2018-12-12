package taojinke.qianxing.lib_weight.loading.view;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import taojinke.qianxing.lib_weight.R;
import taojinke.qianxing.lib_weight.loading.callback.OnRetryClickListener;


/**
 * Created by Administrator on 2017/11/8.
 */

public class NoNetworkStatusView implements IStatusView {

    private Context mContext;
    private OnRetryClickListener mListener;

    private View noNetworkView;
    private TextView messageView;
    private int tag;

    public NoNetworkStatusView(Context context, OnRetryClickListener listener) {
        this.mContext = context;
        this.mListener = listener;

        noNetworkView = LayoutInflater.from(context).inflate(R.layout.layout_no_network, null, false);
        messageView = noNetworkView.findViewById(R.id.tv_message);
        noNetworkView.findViewById(R.id.btn_retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null)
                    mListener.onRetry(view);
            }
        });
        noNetworkView.findViewById(R.id.btn_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(Settings.ACTION_SETTINGS));
            }
        });
    }

    @Override
    public View getView() {
        return noNetworkView;
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
