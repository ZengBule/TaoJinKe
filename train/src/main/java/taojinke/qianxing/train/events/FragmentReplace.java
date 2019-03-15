package taojinke.qianxing.train.events;

/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.events
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/12+18:02
 * 修改人：
 * 修改时间：2019/3/12+18:02
 * 修改备注：
 * ***********************************************
 */
public class FragmentReplace {

    private int majorId;
    private String majorTitle;

    public FragmentReplace(int majorId, String majorTitle
    ) {
        this.majorId = majorId;
        this.majorTitle = majorTitle;
    }

    public int getReplace() {
        return majorId;
    }

    public void setReplace(int majorId) {
        this.majorId = majorId;
    }

    public String getMajorTitle() {
        return majorTitle;
    }

    public void setMajorTitle(String majorTitle) {
        this.majorTitle = majorTitle;
    }
}
