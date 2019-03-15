package taojinke.qianxing.train.ui.train.fragment.base.clazz;

import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;
import taojinke.qianxing.lib_base.base.BaseView;
import taojinke.qianxing.train.ui.train.fragment.base.bean.OtherMajorBean;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.ui.train.fragment.base.clazz
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/12+17:51
 * 修改人：
 * 修改时间：2019/3/12+17:51
 * 修改备注：
 * ***********************************************
 */
public interface TrainClassContract {
    interface ITrainClassView extends BaseView {
        void setStopOnRefresh();

        void initMojorTitle(List<OtherMajorBean> list);
    }

    interface ITrainClassPresenter {
        void getMajorData();


        void getMajorContentByMajorId(int majorId);

        MultiTypeAdapter getMajorContentAdapter();
    }
}
