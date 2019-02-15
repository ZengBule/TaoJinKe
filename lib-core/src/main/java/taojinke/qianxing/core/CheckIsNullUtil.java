package taojinke.qianxing.core;

import android.text.TextUtils;

/**
 * ***********************************************
 * 包路径：taojinke.qianxing.core
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2019/1/14+11:29
 * 修改人：
 * 修改时间：2019/1/14+11:29
 * 修改备注：
 * ***********************************************
 */
public class CheckIsNullUtil {

    public static boolean isNullStr(String str) {
        return TextUtils.isEmpty(str) || TextUtils.equals("null", str);
    }

}
