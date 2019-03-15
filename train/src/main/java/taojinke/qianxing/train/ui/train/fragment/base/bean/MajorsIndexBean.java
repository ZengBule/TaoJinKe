package taojinke.qianxing.train.ui.train.fragment.base.bean;

import java.util.List;

import qianxing.taojinke.ui.basetrain.first.adapter.BadgeListBean;

/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.basetrain.basetrainparent
 * 类描述：
 * 创建人：杨延辉[PHONE：15281087434]
 * 创建时间：2019/2/21+18:30
 * 修改人：
 * 修改时间：2019/2/21+18:30
 * 修改备注：
 * ***********************************************
 */
public class MajorsIndexBean {


    /**
     * bestMajor : null
     * firstStudy : false
     * guideWords : null
     * majorId : 100001
     * otherMajor : null
     */

    public BestMajor bestMajor;
    public boolean firstStudy;
    public String guideWords;
    public int majorId;

    public List<OtherMajorBean> otherMajor;

    public static class BestMajor{
        public int majorId;
        public String majorTitle;
        public int passAveragePay;
        public int currentProgress;
        public List<BadgeListBean> badgeList;
    }

}
