package taojinke.qianxing.train.ui.train.fragment.base.clazz;

import javax.inject.Inject;

import me.drakeet.multitype.MultiTypeAdapter;


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
public class TrainClassPresenter implements TrainClassContract.ITrainClassPresenter {
    @Inject
    TrainClassContract.ITrainClassView mView;

    @Override
    public void getMajorData() {

    }

    @Override
    public void getMajorContentByMajorId(int majorId) {

    }

    @Override
    public MultiTypeAdapter getMajorContentAdapter() {
        return null;
    }
}
