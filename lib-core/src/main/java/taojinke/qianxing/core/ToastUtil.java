package taojinke.qianxing.core;

import android.content.Context;
import android.widget.Toast;


/**
 * Created by Administrator on 2016/6/30.
 */
public class ToastUtil {
    private boolean isShowToast = BuildConfig.DEBUG;

    public static void shortshow(Context context, String string) {
        if (context != null) {
            Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
        }

    }

    public static void longshow(Context context, String string) {
        if (context != null) {
            Toast.makeText(context, string, Toast.LENGTH_LONG).show();
        }
    }

    private static Toast toast;

    public static void singleShow(Context context, String str) {
        if (toast == null) {
            toast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
        } else {
            toast.setText(str);
        }
        toast.show();
    }

    private static Toast mToast;

    /********************** 非连续弹出的Toast ***********************/
    public static void showSingleToast(Context context, int resId) { //R.string.**
        getSingleToast(context, resId, Toast.LENGTH_SHORT).show();
    }

    public static void showSingleToast(Context context, String text) {
        getSingleToast(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void showSingleLongToast(Context context, int resId) {
        getSingleToast(context, resId, Toast.LENGTH_LONG).show();
    }

    public static void showSingleLongToast(Context context, String text) {
        getSingleToast(context, text, Toast.LENGTH_LONG).show();
    }

    /*********************** 连续弹出的Toast ************************/
    public static void showToast(Context context, int resId) {
        getToast(context, resId, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, String text) {
        getToast(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(Context context, int resId) {
        getToast(context, resId, Toast.LENGTH_LONG).show();
    }

    public static void showLongToast(Context context, String text) {
        getToast(context, text, Toast.LENGTH_LONG).show();
    }

    private static Toast getSingleToast(Context context, int resId, int duration) { // 连续调用不会连续弹出，只是替换文本
        return getSingleToast(context, context.getResources().getText(resId).toString(), duration);
    }

    private static Toast getSingleToast(Context context, String text, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, duration);
        } else {
            mToast.setText(text);
        }
        return mToast;
    }

    private static Toast getToast(Context context, int resId, int duration) { // 连续调用会连续弹出
        return getToast(context, context.getResources().getText(resId).toString(), duration);
    }

    private static Toast getToast(Context context, String text, int duration) {
        return Toast.makeText(context, text, duration);
    }
}
