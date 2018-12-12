package taojinke.qianxing.lib_weight.loading.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import taojinke.qianxing.lib_weight.R;
import taojinke.qianxing.lib_weight.loading.callback.OnRetryClickListener;


/**
 * Created by dgg on 2017/11/7.
 */

public class LoadingStatusView implements IStatusView {
    private final View loadingView;
    private TextView messageView;
    private Context context;
    private OnRetryClickListener listener;
    private int tag;

    public LoadingStatusView(Context context, OnRetryClickListener listener) {
        this.context = context;
        this.listener = listener;

        loadingView = LayoutInflater.from(context)
                .inflate(R.layout.layout_loading, null, false);
        messageView = loadingView.findViewById(R.id.tv_message);
        ((ImageView) loadingView.findViewById(R.id.iv_icon)).setImageResource(R.mipmap.state_loading);
    }

    @Override
    public View getView() {
        return loadingView;
    }

    @Override
    public void setTag(int i) {
        this.tag = i;
    }

    @Override
    public int getTag() {
        return tag;
    }

    @Override
    public void setMessage(String s) {
        if (s != null) {
            messageView.setText(s);
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
