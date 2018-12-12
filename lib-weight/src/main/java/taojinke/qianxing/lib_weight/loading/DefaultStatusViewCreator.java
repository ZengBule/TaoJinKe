package taojinke.qianxing.lib_weight.loading;

import android.content.Context;
import android.support.annotation.Nullable;

import taojinke.qianxing.lib_weight.loading.callback.OnRetryClickListener;
import taojinke.qianxing.lib_weight.loading.view.EmptyStatusView;
import taojinke.qianxing.lib_weight.loading.view.ErrorStatusView;
import taojinke.qianxing.lib_weight.loading.view.IStatusView;
import taojinke.qianxing.lib_weight.loading.view.LoadingStatusView;
import taojinke.qianxing.lib_weight.loading.view.NoNetworkStatusView;


public class DefaultStatusViewCreator implements StatusViewCreator {
    @Override
    public IStatusView onCreateStatusView(Context context,
                                          Status status,
                                          @Nullable OnRetryClickListener onRetryClickListener) {

        IStatusView statusView = null;
        switch (status) {
            case ERROR:
                statusView = new ErrorStatusView(context, onRetryClickListener);
                break;
            case EMPTY:
                statusView = new EmptyStatusView(context, onRetryClickListener);
                break;
            case CUSTOM:
                break;
            case LOADING:
                statusView = new LoadingStatusView(context, onRetryClickListener);
                break;
            case NETWORK:
                statusView = new NoNetworkStatusView(context, onRetryClickListener);
                break;
            default:
                break;
        }
        return statusView;
    }
}
