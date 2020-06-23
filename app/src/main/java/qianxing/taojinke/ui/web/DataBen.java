package qianxing.taojinke.ui.web;

/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.web
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/4/9+15:51
 * 修改人：
 * 修改时间：2019/4/9+15:51
 * 修改备注：
 * ***********************************************
 */
public class DataBen {

    /**
     * apiId : c48be2f8bf59
     * code : 0
     * msg : 成功
     * data : {"id":"MJuXAOJ3jM5.dsDFuN.45ad3b","title":"adfasdfasdf","video_url":"","thumb":"http://niuStg.ni5t.cn/uploads/20190404/1629852816243687427.jpg","intro":"asdf","published_time":"2019-04-04 03:32:54.725043","content":"<p><img class='wscnph' src='http://niuStg.ni5t.cn/uploads/20190408/1630252409402949635.jpg' /><\/p>","meadows_name":"牧场名称222v","author":"asdf"}
     */

    private String apiId;
    private int code;
    private String msg;
    private DataBean data;

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : MJuXAOJ3jM5.dsDFuN.45ad3b
         * title : adfasdfasdf
         * video_url :
         * thumb : http://niuStg.ni5t.cn/uploads/20190404/1629852816243687427.jpg
         * intro : asdf
         * published_time : 2019-04-04 03:32:54.725043
         * content : <p><img class='wscnph' src='http://niuStg.ni5t.cn/uploads/20190408/1630252409402949635.jpg' /></p>
         * meadows_name : 牧场名称222v
         * author : asdf
         */

        private String id;
        private String title;
        private String video_url;
        private String thumb;
        private String intro;
        private String published_time;
        private String content;
        private String meadows_name;
        private String author;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getPublished_time() {
            return published_time;
        }

        public void setPublished_time(String published_time) {
            this.published_time = published_time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getMeadows_name() {
            return meadows_name;
        }

        public void setMeadows_name(String meadows_name) {
            this.meadows_name = meadows_name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }
}
