package taojinke.qianxing.core;

/**
 * ***********************************************
 * 包路径：taojinke.qianxing.core
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2019/1/14+11:26
 * 修改人：
 * 修改时间：2019/1/14+11:26
 * 修改备注：
 * ***********************************************
 */
public class DateFormatUtil {

    public static String isNull(String str) {
        if (str == null || "".equals(str) || "null".equals(str)) {
            return "";
        } else {
            return str;
        }

    }

}
