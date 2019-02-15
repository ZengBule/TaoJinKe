package taojinke.qianxing.lib_kernel.logtofile;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created by Administrator on 2018/5/8.
 */

public class LogToFile {
    private static Context mContext;
    private static String TAG = "LogToFile";

    private static String logPath = null;//log日志存放路径
    private static String logCurrentUploadPath = null;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);//日期格式;

    /**
     * 初始化，须在使用之前设置，最好在Application创建时调用
     *
     * @param context
     */
    public static void init(Context context) {
        logPath = getFilePath(context) + "/Logs";//获得文件储存路径,在后面加"/Logs"建立子文件夹
        logCurrentUploadPath = getFilePath(context) + "/LogsUpload";
    }

    /**
     * 获得文件存储路径
     *
     * @return
     */
    private static String getFilePath(Context context) {
        mContext = context;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ||
                !Environment.isExternalStorageRemovable()) {//如果外部储存可用
            if (context.getExternalFilesDir(null) == null) {
                return context.getFilesDir().getPath();//直接存在/data/data里，非root手机是看不到的
            } else {
                return context.getExternalFilesDir(null).getPath();//获得外部存储路径,默认路径为 /storage/emulated/0/Android/data/com.waka.workspace.logtofile/files/Logs/log_2016-03-14_16-15-09.log

            }
        } else {
            return context.getFilesDir().getPath();//直接存在/data/data里，非root手机是看不到的
        }
    }

    private static final char VERBOSE = 'v';

    private static final char DEBUG = 'd';

    private static final char INFO = 'i';

    private static final char WARN = 'w';

    private static final char ERROR = 'e';

    public static void v(String tag, String msg) {
        writeToFile(VERBOSE, tag, msg);
    }

    public static void d(String tag, String msg) {
        writeToFile(DEBUG, tag, msg);
    }

    public static void i(String tag, String msg) {
        writeToFile(INFO, tag, msg);
    }

    public static void w(String tag, String msg) {
        writeToFile(WARN, tag, msg);
    }

    public static void e(String tag, String msg) {
        writeToFile(ERROR, tag, msg);
    }

    /**
     * 将log信息写入文件中
     *
     * @param type
     * @param tag
     * @param msg
     */
    private static void writeToFile(char type, String tag, String msg) {

        if (null == logPath) {
            Log.e(TAG, "logPath == null ，未初始化LogToFile");
            return;
        }

        String fileName = logPath + "/log_" + /*dateFormat.format(new Date())*/"tangwenhui" + ".log";//log日志名，使用时间命名，保证不重复
        String log = dateFormat.format(new Date()) + " " + type + " " + tag + " " + msg + "\n";//log日志内容，可以自行定制

        //如果父路径不存在
        File file = new File(logPath);
        if (!file.exists()) {
            file.mkdirs();//创建父路径
        }

        File saveFile = new File(fileName);
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //FileOutputStream会自动调用底层的close()方法，不用关闭
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            boolean append = false;
            if (getFileSize(saveFile) > 1024 * 1024) {
                append = false;
                readFile(saveFile);
            } else {
                append = true;
            }
            //这里的第二个参数代表追加还是覆盖，true为追加，flase为覆盖
            fos = new FileOutputStream(fileName, append);
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(log);
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();//关闭缓冲流
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void readFile(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);//建立一个输入流对象
        byte[] buf = new byte[1024];//每次读入文件数据量
        int len = -1;
        StringBuilder sbuf = new StringBuilder();
        while ((len = (fis.read(buf))) != -1) {
            sbuf.append(new String(buf, 0, len));
        }
        writeFile(sbuf.toString());
        fis.close();
    }

    //写入文件
    private static void writeFile(String content) throws Exception {
        File file = new File(logCurrentUploadPath);//写入路径
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(content.getBytes());
        fos.close();//关闭文件

//        Intent intent = new Intent(mContext, UploadLogService.class);
//        intent.putExtra("filePath", logCurrentUploadPath);
//        mContext.startService(intent);

    }

    /**
     * 获取指定文件大小(单位：字节)
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static long getFileSize(File file) throws Exception {
        if (file == null) {
            return 0;
        }
        long size = 0;
        if (file.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(file);
            size = fis.available();
        }
        return size;
    }

    /**
     * 检测到后台状态 需要上传日志的时候调用此方法
     */
    public static void uploadAppLogToService() {

        if (null == logPath) {
            Log.e(TAG, "logPath == null ，未初始化LogToFile");
            return;
        }

        String fileName = logPath + "/log_" + /*dateFormat.format(new Date())*/"tangwenhui" + ".log";//log日志名，使用时间命名，保证不重复

        //如果父路径不存在
        File file = new File(logPath);
        if (!file.exists()) {
            file.mkdirs();//创建父路径
        }
        File saveFile = new File(fileName);
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            readFile(saveFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
