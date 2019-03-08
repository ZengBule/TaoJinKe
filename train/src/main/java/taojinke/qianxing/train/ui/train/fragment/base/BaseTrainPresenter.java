package taojinke.qianxing.train.ui.train.fragment.base;

import javax.inject.Inject;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.ui.train.fragment.base
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/7+18:07
 * 修改人：
 * 修改时间：2019/3/7+18:07
 * 修改备注：
 * ***********************************************
 */
public class BaseTrainPresenter implements BaseTrainContract.IBaseTrainPresenter {
    @Inject
    BaseTrainContract.IBaseTrainView mView;
}
