package taojinke.qianxing.core;

import android.os.Environment;
import android.text.TextPaint;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/7/6.
 */
public class OtherUtil {

    //判断是否是手机号码
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^[\\d]{11}$");

        Matcher m = p.matcher(mobiles);

        return m.matches();
    }

    public static boolean is6or20(String pwd) {
        Pattern p = Pattern.compile("^\\S{6,20}$");

        Matcher m = p.matcher(pwd);

        return m.matches();
    }

    public static ArrayList<String> SplitToList(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str!=null&&!"".equals(str)&&!"null".equals(str)){
            String[] strarray = str.split(";");
            for (int i = 0; i < strarray.length; i++) {
                list.add(strarray[i]);
            }
        }
        return list;
    }

    public static void SetBold(TextView tv){
        TextPaint tp = tv.getPaint();
        tp.setFakeBoldText(true);
    }

    //判断是否有SD卡
    public static boolean isSDCardEnable()
    {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);

    }


}
