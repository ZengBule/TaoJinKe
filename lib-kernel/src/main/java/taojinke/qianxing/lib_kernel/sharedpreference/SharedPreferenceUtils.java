package taojinke.qianxing.lib_kernel.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by yhl on 2016/6/8.
 */

public class SharedPreferenceUtils {

    public static final int DB_VERSION = 1;
    private static final String FILE_NAME = "config";
    /**
     * Im fromAccount
     */
    private static final String IM_FILE = "IM_FILE";
    private static final String IM_ACCOUNT_KEY = "fromAccount";
    private static final String IM_REAL_NAME_KEY = "realName";
    private static final String ATTR_HAD_GUIDED = "had_im_login";
    private static final String IM_RECIPIENTS = "recipients";
    /**
     * 学习路径id记录
     */
    private static final String STUDY_FILE_NAME = "study";
    private static final String TEST_FILE_NAME = "test_file";
    /**
     * 考试相关保存
     */
    private static final String EXAM_FILE_NAME = "exam_file";
    /**
     * 培训相关保存
     */

    private static final String GUIDE_FILE_NAME = "guide_file";
    private static final String TRAIN_VIDEO_TIME_REC = "video_play_time_rec";
    private static final String TRAIN_RECORDER = "train_recorder";

    private static final String HUA_WEI_TOKEN = "hua_wei_token";


    public static String getPreference(String pKey, String key, Context context) {
        if (context != null) {
            SharedPreferences preference = context.getSharedPreferences(pKey, Context.MODE_PRIVATE);
            return preference.getString(key, "");
        }

        return "";
    }

    /**
     * Token
     */

    public static String getReqToken(Context context) {
        SharedPreferences preference = context.getSharedPreferences("Token", Context.MODE_PRIVATE);
        return preference.getString("token", "");
    }

    public static void savePreference(Context context, String pKey, String key, String value) {


        SharedPreferences preference = context.getSharedPreferences(pKey, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString(key, value);

        editor.apply();
    }

    public static void clearPreference(Context context, String pKey) {
        SharedPreferences preference = context.getSharedPreferences(pKey, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 用户名
     */

    public static String getUserNamePreference(Context context) {

        SharedPreferences preference = context.getSharedPreferences("UserName", Context.MODE_PRIVATE);

        return preference.getString("username", "");
    }

    public static void saveUserNamePreference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences("UserName", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("username", value);

        editor.apply();
    }

    public static void clearUserNamePreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("UserName", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    public static void saveUserSex(Context context, String sex) {
        SharedPreferences preference = context.getSharedPreferences("sex", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("userSex", sex);

        editor.apply();
    }

    public static String getUserSex(Context context) {
        SharedPreferences preference = context.getSharedPreferences("sex", Context.MODE_PRIVATE);

        return preference.getString("userSex", "");
    }

    /**
     * 用户名
     */

    public static String getPhonePreference(Context context) {

        SharedPreferences preference = context.getSharedPreferences("Phone", Context.MODE_PRIVATE);

        return preference.getString("phone", "");
    }

    public static void savePhonePreference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences("Phone", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("phone", value);

        editor.apply();
    }

    public static String getRefreshTimePreference(Context context, String type) {
        if (context == null) {
            return "";
        }
        SharedPreferences
                preference = context.getSharedPreferences("RefreshTime", Context.MODE_PRIVATE);
        return preference.getString("refresh_time_" + type, "");
    }

    public static void saveRefreshTimePreference(Context context, String value, String type) {
        if (context == null) {
            return;
        }
        SharedPreferences preference = context.getSharedPreferences("RefreshTime", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString("refresh_time_" + type, value);
        editor.apply();
    }

    public static void clearPhonePreference(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences preference = context.getSharedPreferences("Phone", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    /**
     * 登录名
     */

    public static String getLoginNamePreference(Context context) {

        SharedPreferences preference = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return preference.getString("login_name", "");
    }

    public static void saveLoginNamePreference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString("login_name", value);
        editor.apply();
    }

    public static void clearLoginNamePreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.remove("login_name");
        editor.apply();
    }

    /**
     * 头像
     */

    public static String getHeadPreference(Context context) {

        SharedPreferences preference = context.getSharedPreferences("Head", Context.MODE_PRIVATE);

        return preference.getString("head", "");
    }

    public static void saveHeadPreference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences("Head", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("head", value);
        editor.apply();
    }

    public static void clearHeadPreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("Head", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    /**
     * voip
     */

    public static String getVoipPreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("Voip", Context.MODE_PRIVATE);

        return preference.getString("vip", "");
    }

    public static void saveVoipPerference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences("Voip", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("vip", value);

        editor.apply();
    }

    public static void clearVoipPerference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("Voip", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    /**
     * voippsd
     */

    public static String getVoipPwdPreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("VoipPwd", Context.MODE_PRIVATE);

        return preference.getString("vipPwd", "");
    }

    public static void saveVoipPwdPerference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences("VoipPwd", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("vipPwd", value);

        editor.apply();
    }

    public static void clearVoipPwdPerference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("VoipPwd", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    /**
     * userid
     */
    public static String getUserIDPreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("UserID", Context.MODE_PRIVATE);

        return preference.getString("userid", "");
    }

    public static void saveUserIDPerference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences("UserID", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("userid", value);

        editor.apply();
    }

    public static void clearUserIDPerference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("UserID", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    /**
     * paymentAccountId
     */
    public static String getpaymentAccountIdPreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("paymentAccountId", Context.MODE_PRIVATE);

        return preference.getString("AccountId", "");
    }

    public static void savepaymentAccountIdPerference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences("paymentAccountId", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("AccountId", value);

        editor.apply();
    }

    public static void clearpaymentAccountIdPerference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("paymentAccountId", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    /**
     * VersionID
     */
    public static String getVersionIDPreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("VersionID", Context.MODE_PRIVATE);

        return preference.getString("versionID", "");
    }

    public static void saveVersionIDPerference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences("VersionID", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("versionID", value);

        editor.apply();
    }

    public static void clearVersionIDPerference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("VersionID", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    /**
     * isLogin
     */
    public static String getisLoginPreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);

        return preference.getString("loginronot", "");
    }

    public static void saveisLoginPerference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("loginronot", value);

        editor.apply();
    }

    public static void clearisLoginPerference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    public static void saveGuidePageTag(Context context, String tag) {
        SharedPreferences preference = context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("loginronot", tag);
        editor.apply();
    }

    /**
     * checktime
     */
    public static long getchecktimePreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("checktime", Context.MODE_PRIVATE);

        long time = 0;
        return preference.getLong("ctime", time);
    }

    public static void savechecktimePerference(Context context, long value) {
        SharedPreferences preference = context.getSharedPreferences("checktime", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putLong("ctime", value);
        editor.apply();
    }

    public static void clearchecktimePerference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("checktime", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    /**
     * checktime
     */
    public static String getpxPreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("peixun", Context.MODE_PRIVATE);

        return preference.getString("px", "");
    }

    public static void savepxPerference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences("peixun", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("px", value);
        editor.apply();
    }

    public static void clearpxPerference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("peixun", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    /**
     * SP
     */
    public static String getSPPreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("SP", Context.MODE_PRIVATE);

        return preference.getString("sp", "");
    }

    public static void saveSPPerference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences("SP", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("sp", value);
        editor.apply();
    }

    public static void clearSPPerference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("SP", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    public static void setHadImLogin(Context context, boolean hadGuided) {
        SharedPreferences preference = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        preference.edit().putBoolean(ATTR_HAD_GUIDED, hadGuided).apply();
    }

    public static boolean getHadImLogin(Context context) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getBoolean(ATTR_HAD_GUIDED, false);
    }

    public static void clearHadIMlogin(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        preferences.edit().clear().apply();
    }

    public static int getDBVersion(Context context) {
        SharedPreferences preference = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

        return preference.getInt("db_version", 0);
    }

    public static void saveDBVersion(Context context, int value) {
        SharedPreferences preference = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putInt("db_version", value);
        editor.apply();
    }

    public static String getImAccountPreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences(IM_FILE, Context.MODE_PRIVATE);
        return preference.getString(IM_ACCOUNT_KEY, "");
    }

    public static void saveImAccountPerference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences(IM_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(IM_ACCOUNT_KEY, value);
        editor.apply();
    }


    public static String getRecipientsPreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("Recipients", Context.MODE_PRIVATE);
        return preference.getString(IM_RECIPIENTS, "");
    }

    public static void saveRecipientsPerference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences("Recipients", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(IM_RECIPIENTS, value);
        editor.apply();
    }

    public static void clearImFilePerference(Context context) {
        SharedPreferences preference = context.getSharedPreferences(IM_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 用户真实名
     */

    public static String getRealNamePreference(Context context) {

        SharedPreferences preference = context.getSharedPreferences(IM_FILE, Context.MODE_PRIVATE);

        return preference.getString(IM_REAL_NAME_KEY, "");
    }

    public static void saveRealNamePreference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences(IM_FILE, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString(IM_REAL_NAME_KEY, value);

        editor.apply();
    }

    public static void clearRealNamePreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences(IM_FILE, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    /**
     * PatchUpdateTime
     */

    public static long getPatchRequestTime(Context context) {
        SharedPreferences preference = context.getSharedPreferences("PatchRequest", Context.MODE_PRIVATE);
        return preference.getLong("patch_request_time", 0);
    }

    public static void savePatchRequestTimePreference(Context context, long value) {
        SharedPreferences preference = context.getSharedPreferences("PatchRequest", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putLong("patch_request_time", value);
        editor.apply();
    }

    public static void clearPatchRequestTimePreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences("PatchUpdate", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.clear();
        editor.apply();
    }

    public static String getStudyPathPreference(Context context) {

        SharedPreferences preference = context.getSharedPreferences(STUDY_FILE_NAME, Context.MODE_PRIVATE);

        return preference.getString("study_path_id", "");
    }

    public static void saveStudyPathPreference(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences(STUDY_FILE_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.putString("study_path_id", value);

        editor.apply();
    }

    public static void clearStudyPreference(Context context) {
        SharedPreferences preference = context.getSharedPreferences(STUDY_FILE_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preference.edit();
        editor.clear();

        editor.apply();
    }

    public static boolean isTestEnvironment(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(TEST_FILE_NAME, Context.MODE_PRIVATE);
        return preferences.getBoolean("test_environment", false);
    }

    public static void setTestEnvironment(Context context, boolean isTest) {
        SharedPreferences preferences = context.getSharedPreferences(TEST_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("test_environment", isTest);
        editor.apply();
    }

    public static boolean isPreOnLineEnvironment(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(TEST_FILE_NAME, Context.MODE_PRIVATE);
        return preferences.getBoolean("pre_online_environment", false);
    }

    public static void setPreOnLineEnvironment(Context context, boolean isTest) {
        SharedPreferences preferences = context.getSharedPreferences(TEST_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("pre_online_environment", isTest);
        editor.apply();
    }

    public static void clearTestEnvironment(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(TEST_FILE_NAME, Context.MODE_PRIVATE);
        preferences.edit().clear().apply();
    }

    public static long getExamBeginTime(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(EXAM_FILE_NAME, Context.MODE_PRIVATE);
        return preferences.getLong("exam_begin_time", 0);
    }

    public static void setExamBeginTime(Context context, long time) {
        SharedPreferences preferences = context.getSharedPreferences(EXAM_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong("exam_begin_time", time);
        editor.apply();
    }

    public static int getExamTime(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(EXAM_FILE_NAME, Context.MODE_PRIVATE);
        return preferences.getInt("exam_time", 0);
    }

    public static void setExamTime(Context context, int time) {
        SharedPreferences preferences = context.getSharedPreferences(EXAM_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("exam_time", time);
        editor.apply();
    }

    public static void clearExam(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(EXAM_FILE_NAME, Context.MODE_PRIVATE);
        preferences.edit().clear().apply();
    }

    public static Map<String, Boolean> getGuidePageTagMap(Context context) {
        Map<String, Boolean> datas = new HashMap<>();
        SharedPreferences sp = context.getSharedPreferences("GuidePageConfig",
                Context.MODE_PRIVATE);
        String result = sp.getString("GuidePageTag", "");
        try {
            JSONArray array = new JSONArray(result);
            for (int i = 0; i < array.length(); i++) {
                JSONObject itemObject = array.getJSONObject(i);
                JSONArray names = itemObject.names();
                if (names != null) {
                    for (int j = 0; j < names.length(); j++) {
                        String name = names.getString(j);
                        boolean value = itemObject.getBoolean(name);
                        datas.put(name, value);
                    }
                }
            }
        } catch (JSONException e) {

        }
        return datas;
    }

    public static void putTagToGuidePageMap(Context context, String key, boolean isShow) {
        Map<String, Boolean> guidePageMap = getGuidePageTagMap(context);
        guidePageMap.put(key, isShow);
        putHashMapData(context, guidePageMap);
    }

    public static void putHashMapData(Context context, Map<String, Boolean> datas) {
        JSONArray mJsonArray = new JSONArray();
        Iterator<Map.Entry<String, Boolean>> iterator = datas.entrySet().iterator();
        JSONObject object = new JSONObject();
        while (iterator.hasNext()) {
            Map.Entry<String, Boolean> entry = iterator.next();
            try {
                object.put(entry.getKey(), entry.getValue());
            } catch (JSONException e) {

            }
        }
        mJsonArray.put(object);
        SharedPreferences sp = context.getSharedPreferences("GuidePageConfig",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("GuidePageTag", mJsonArray.toString());
        editor.apply();
    }

    /**
     * 检查  tag 是否已经存在
     */
    public static boolean checkTagIsShow(Context context, String tag) {
        Map<String, Boolean> guidePageMap = getGuidePageTagMap(context);
        if (guidePageMap == null || guidePageMap.isEmpty()) {
            return false;
        }
        boolean isExist = guidePageMap.containsKey(tag);
        if (!isExist) {
            return false;
        }
        boolean isShow = guidePageMap.get(tag);
        if (!isShow) {
            return false;
        }
        return true;
    }

    public static boolean isTrainHasGuide(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(GUIDE_FILE_NAME, Context.MODE_PRIVATE);
        return preferences.getBoolean("train_guide", false);
    }

    public static void setTrainHasGuide(Context context, boolean hasGuide) {
        SharedPreferences preferences = context.getSharedPreferences(GUIDE_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("train_guide", hasGuide);
        editor.apply();
    }

    public static void clearGuideStatus(Context context) {
        context.getSharedPreferences(GUIDE_FILE_NAME, Context.MODE_PRIVATE).edit().clear();
    }

    public static int getTrainVideoTime(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(TRAIN_VIDEO_TIME_REC, Context.MODE_PRIVATE);
        return preferences.getInt(key, 0);
    }

    public static void setTrainVideoTime(Context context, String key, int time) {
        SharedPreferences preferences = context.getSharedPreferences(TRAIN_VIDEO_TIME_REC, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, time);
        editor.apply();
    }

    public static void clearTrainVideoTime(Context context) {
        context.getSharedPreferences(TRAIN_VIDEO_TIME_REC, Context.MODE_PRIVATE).edit().clear().apply();
    }

    public static long getTrainPageStartTime(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(TRAIN_RECORDER, Context.MODE_PRIVATE);
        return preferences.getLong(key, 0);
    }

    public static void saveTrainPageStartTime(Context context, String key, long startTime) {
        SharedPreferences preferences = context.getSharedPreferences(TRAIN_RECORDER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, startTime);
        editor.apply();
    }

    public static long getTrainPageEndTime(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(TRAIN_RECORDER, Context.MODE_PRIVATE);
        return preferences.getLong(key + "end", 0);
    }

    public static void saveTrainPageEndTime(Context context, String key, long endTime) {
        SharedPreferences preferences = context.getSharedPreferences(TRAIN_RECORDER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key + "end", endTime);
        editor.apply();
    }

    public static void clearTrainPageTime(Context context) {
        context.getSharedPreferences(TRAIN_RECORDER, Context.MODE_PRIVATE).edit().clear().apply();
    }

    public static void saveHuaWeiToken(Context context, String value) {
        SharedPreferences preference = context.getSharedPreferences(HUA_WEI_TOKEN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString("huatoken", value);
        editor.apply();
    }

    public static String getHwaWeiToken(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(HUA_WEI_TOKEN, Context.MODE_PRIVATE);
        return preferences.getString("huatoken", "");
    }
}

