package taojinke.qianxing.lib_weight.loading.change;


import androidx.annotation.NonNull;
import taojinke.qianxing.lib_weight.loading.view.IStatusView;


/**
 * Created by leeiides on 2017/6/23.
 */

public interface SwitchLayoutHelper {
    void switchLayout(@NonNull IStatusView targetView);

    void removeAllViews();

    @NonNull
    IStatusView getCurrentStatusView();
}
