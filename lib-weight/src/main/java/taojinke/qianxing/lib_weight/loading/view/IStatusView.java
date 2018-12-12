package taojinke.qianxing.lib_weight.loading.view;

import android.view.View;

/**
 * Created by dgg on 2017/11/7.
 */

public interface IStatusView {
    View getView();

    void setTag(int tag);

    int getTag();

    void setMessage(String message);

    void setButtonText(String button);

    void setStatusImage(int resId);

    void startAnimation();

    void stopAnimation();

    void destroy();
}
