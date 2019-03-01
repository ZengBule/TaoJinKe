package taojinke.qianxing.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/**
 * ***********************************************
 * 包路径：taojinke.qianxing.core
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/1+11:40
 * 修改人：
 * 修改时间：2019/3/1+11:40
 * 修改备注：
 * ***********************************************
 */
public class NetworkInfoUtils {


    // 高位表示网络正常
    public static final int NET_WORK_3G_DISCONNECTED = 1;
    public static final int NET_WORK_WIFI_DISCONNECTED = 1 << 1;

    public static final int NET_WORK_3G_DISCONNECTING = 1 << 2;
    public static final int NET_WORK_WIFI_DISCONNECTING = 1 << 3;

    public static final int NET_WORK_3G_CONNECTING = 1 << 4;
    public static final int NET_WORK_WIFI_CONNECTING = 1 << 5;

    public static final int NET_WORK_3G_CONNECTED = 1 << 6;
    public static final int NET_WORK_WIFI_CONNECTED = 1 << 7;

    public static int getNetworkStatu(Context context) {
        ConnectivityManager conMan = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        int mobile_state = NET_WORK_WIFI_CONNECTED;

        if (conMan == null) {
            return mobile_state;
        }

        // mobile 3G Data Network
        NetworkInfo.State mobile = conMan.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .getState();
        if (mobile == NetworkInfo.State.DISCONNECTED) {
            mobile_state = NET_WORK_3G_DISCONNECTED;
        } else if (mobile == NetworkInfo.State.DISCONNECTING) {
            mobile_state = NET_WORK_3G_CONNECTING;
        } else if (mobile == NetworkInfo.State.CONNECTING) {
            mobile_state = NET_WORK_3G_CONNECTING;
        } else if (mobile == NetworkInfo.State.CONNECTED) {
            mobile_state = NET_WORK_3G_CONNECTED;
        }

        // wifi
        int wifi_state = 0;
        State wifi = conMan.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState();
        if (wifi == State.DISCONNECTED) {
            wifi_state = NET_WORK_WIFI_DISCONNECTED;
        } else if (wifi == State.DISCONNECTING) {
            wifi_state = NET_WORK_WIFI_DISCONNECTING;
        } else if (wifi == State.CONNECTING) {
            wifi_state = NET_WORK_WIFI_CONNECTING;
        } else if (wifi == State.CONNECTED) {
            wifi_state = NET_WORK_WIFI_CONNECTED;
        }

        return (mobile_state | wifi_state);
    }

    public static boolean isNetworkConnected(Context context) {
        int state = getNetworkStatu(context);

        if (state >= (1 << 6)) {
            return true;
        }

        return false;
    }

    /********************************** 换一种实现方案 *******************************************************/
    /**
     * 没有网络
     */
    public static final int NETWORKTYPE_INVALID = 0;
    /**
     * wap网络
     */
    public static final int NETWORKTYPE_WAP = 1;
    /**
     * 2G网络
     */
    public static final int NETWORKTYPE_2G = 2;
    /**
     * 3G和3G以上网络，或统称为快速网络
     */
    public static final int NETWORKTYPE_3G = 3;
    /**
     * wifi网络
     */
    public static final int NETWORKTYPE_WIFI = 4;

    private static boolean isFastMobileNetwork(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);

        if (telephonyManager == null) {
            return false;
        }

        switch (telephonyManager.getNetworkType()) {
            case TelephonyManager.NETWORK_TYPE_1xRTT:
                return false;
            case TelephonyManager.NETWORK_TYPE_CDMA:
                return false;
            case TelephonyManager.NETWORK_TYPE_EDGE:
                return false;
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                return true;
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                return true;
            case TelephonyManager.NETWORK_TYPE_GPRS:
                return false;
            case TelephonyManager.NETWORK_TYPE_HSDPA:
                return true;
            case TelephonyManager.NETWORK_TYPE_HSPA:
                return true;
            case TelephonyManager.NETWORK_TYPE_HSUPA:
                return true;
            case TelephonyManager.NETWORK_TYPE_UMTS:
                return true;
            case TelephonyManager.NETWORK_TYPE_EHRPD:
                return true;
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                return true;
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return true;
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return false;
            case TelephonyManager.NETWORK_TYPE_LTE:
                return true;
            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                return false;
            default:
                return false;
        }
    }

    /**
     * 获取网络状态，wifi,wap,2g,3g.
     *
     * @param context 上下文
     * @return int 网络状态 {@link #NETWORKTYPE_2G},{@link #NETWORKTYPE_3G},          *
     * {@link #NETWORKTYPE_INVALID},{@link #NETWORKTYPE_WAP}*
     * <p>
     * {@link #NETWORKTYPE_WIFI}
     */

    public static int getNetWorkType(Context context) {

        if (context == null) {
            return NETWORKTYPE_WIFI;
        }

        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (manager == null) {
            return NETWORKTYPE_WIFI;
        }

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        int networtType = NETWORKTYPE_INVALID;
        if (networkInfo != null && networkInfo.isConnected()) {
            String type = networkInfo.getSubtypeName();

            if (type.equalsIgnoreCase("WIFI")) {
                networtType = NETWORKTYPE_WIFI;
            } else if (type.equalsIgnoreCase("MOBILE")) {
                String proxyHost = android.net.Proxy.getHost(context);

                networtType = TextUtils.isEmpty(proxyHost) ? (isFastMobileNetwork(context) ? NETWORKTYPE_3G
                        : NETWORKTYPE_2G)
                        : NETWORKTYPE_WAP;
            }
        } else {
            networtType = NETWORKTYPE_INVALID;
        }

        return networtType;
    }

    public static String getNetworkTypeString(int networkType) {
        switch (networkType) {
            case NETWORKTYPE_INVALID:
                return "NONE";
            case NETWORKTYPE_2G:
                return "2G";
            case NETWORKTYPE_3G:
                return "3G";
            case NETWORKTYPE_WAP:
                return "WAP";
            case NETWORKTYPE_WIFI:
                return "WIFI";
            default:
                return "NONE";
        }
    }

}
