package qianxing.taojinke.util;

import android.content.Context;

import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;

/**
 * ***********************************************
 * 包路径：taojinke.qianxing.core
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2019/1/14+15:11
 * 修改人：
 * 修改时间：2019/1/14+15:11
 * 修改备注：
 * ***********************************************
 */
public class BaseUrlManger {
    public static String setBaseUrl(Context context) {
        try {
            if (SharedPreferenceUtils.isTestEnvironment(context)) {
                if (SharedPreferenceUtils.isPreOnLineEnvironment(context)) {
                    //预上线环境
                    return "http://t1.itaojin.cn/";
                } else {
                    //本地测试环境
                    return "http://192.168.0.240/";
                }

            } else {
                //线上环境
                return "https://t.itaojin.cn/";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "https://t.itaojin.cn/";
        }

    }

    public static String getBaseWebUrl(Context context) {
        try {
            if (SharedPreferenceUtils.isTestEnvironment(context)) {
                if (SharedPreferenceUtils.isPreOnLineEnvironment(context)) {
                    //预上线环境   测试环境
                    return "ws://192.168.4.13:13080/tj-wsdc-connector-web/websocket?";
                } else {
                    //本地测试环境
                    return "ws://192.168.4.13:13080/tj-wsdc-connector-web/websocket?";
                }

            } else {
                //线上环境
                return "ws://www.itaojin.cn/tj-wsdc-connector-web/websocket?";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "ws://www.itaojin.cn/tj-wsdc-connector-web/websocket?";
        }
    }
}
