package taojinke.qianxing.lib_weight.loading;

import android.content.Context;
import android.support.annotation.Nullable;

import taojinke.qianxing.lib_weight.loading.callback.OnRetryClickListener;
import taojinke.qianxing.lib_weight.loading.view.IStatusView;


/**
 * Created by dgg on 2017/11/7.
 */

public interface StatusViewCreator {
	IStatusView onCreateStatusView(Context context, Status status, @Nullable OnRetryClickListener l);
}
