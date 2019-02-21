package taojinke.qianxing.lib_weight;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;


public class DialogUtils {
    static AVLoadingIndicatorView avi;

    public static Dialog createLoadingDialog(Context context, String msg) {
        if(context == null){
            return null;
        }
        if(context instanceof Activity){
            if(((Activity)context).isFinishing()){
                return null;
            }
        }
        LayoutInflater inflater = LayoutInflater.from(context);
        // 得到加载view
        View v = inflater.inflate(R.layout.dialog_loading, null);

        LinearLayout layout = (LinearLayout) v
                .findViewById(R.id.dialog_loading_view);
        // 提示文字
        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);
        LinearLayout ll_bg = v.findViewById(R.id.ll_bg);
        avi = v.findViewById(R.id.avi);
        avi.show();

        // 创建自定义样式dialog
        Dialog loadingDialog = new Dialog(context, R.style.MyDialogStyle);

        if(TextUtils.isEmpty(msg)){
            ll_bg.setBackgroundResource(0);
            // 设置加载信息
            tipTextView.setText("");
            avi.setIndicatorColor(Color.parseColor("#77a9fd"));
            avi.setIndicator("BallClipRotateIndicator");
            // 点击加载框以外的区域
            loadingDialog.setCanceledOnTouchOutside(true);
        }else{
            ll_bg.setBackgroundResource(R.drawable.loading_bg);
            // 设置加载信息
            tipTextView.setText(msg);
            avi.setIndicatorColor(Color.WHITE);
            avi.setIndicator("BallClipRotatePulseIndicator");
            // 点击加载框以外的区域
            loadingDialog.setCanceledOnTouchOutside(false);
        }
        // 是否可以按“返回键”消失
        loadingDialog.setCancelable(true);
        // 设置布局
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        /**
         *将显示Dialog的方法封装在这里面
         */
        Window window = loadingDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setGravity(Gravity.CENTER);
        window.setAttributes(lp);
        window.setWindowAnimations(R.style.PopWindowAnimStyle);
        loadingDialog.show();

        return loadingDialog;
    }

//    /**
//     * 关闭dialog
//     *
//     * http://blog.csdn.net/qq_21376985
//     *
//     * @param mDialogUtils
//     */
//    public static void closeDialog(Dialog mDialogUtils) {
//        if(avi!=null){
//            avi.hide();
//        }
//        if (mDialogUtils != null && mDialogUtils.isShowing() ) {
//            mDialogUtils.dismiss();
//        }
//    }

    public static void closeDialog(Activity activity, Dialog dialog){
        if(avi!=null){
            avi.hide();
        }
        if(activity!=null&&!activity.isFinishing()){
            if (dialog != null && dialog.isShowing() ) {
                dialog.dismiss();
            }
        }

    }

}