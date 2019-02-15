package qianxing.taojinke.ui.launcher;

/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.launcher
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/14+17:43
 * 修改人：
 * 修改时间：2019/2/14+17:43
 * 修改备注：
 * ***********************************************
 */
public class VersionInfo {


    /**
     * data : {"description":"修复培训课程通过后奖杯未展示的问题","version":"5.4.2","createTime":1548726888000,"downloads":379,"urlPath":"http://o84wdzp64.bkt.clouddn.com/2019-01/e661cb3e83234be8934c3bb90871e637.apk","appPlatform":"0","appType":"0","id":205}
     * status : true
     * message : 成功
     */

    private DataBean data;
    private boolean status;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * description : 修复培训课程通过后奖杯未展示的问题
         * version : 5.4.2
         * createTime : 1548726888000
         * downloads : 379
         * urlPath : http://o84wdzp64.bkt.clouddn.com/2019-01/e661cb3e83234be8934c3bb90871e637.apk
         * appPlatform : 0
         * appType : 0
         * id : 205
         */

        private String description;
        private String version;
        private long createTime;
        private int downloads;
        private String urlPath;
        private String appPlatform;
        private String appType;
        private int id;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getDownloads() {
            return downloads;
        }

        public void setDownloads(int downloads) {
            this.downloads = downloads;
        }

        public String getUrlPath() {
            return urlPath;
        }

        public void setUrlPath(String urlPath) {
            this.urlPath = urlPath;
        }

        public String getAppPlatform() {
            return appPlatform;
        }

        public void setAppPlatform(String appPlatform) {
            this.appPlatform = appPlatform;
        }

        public String getAppType() {
            return appType;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
