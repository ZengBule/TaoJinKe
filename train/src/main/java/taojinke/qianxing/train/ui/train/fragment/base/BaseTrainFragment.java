package taojinke.qianxing.train.ui.train.fragment.base;

import android.os.Bundle;

import javax.inject.Inject;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import taojinke.qianxing.lib_kernel.http.net.rx.databus.RegisterRxBus;
import taojinke.qianxing.lib_kernel.http.net.rx.databus.RxBus;
import taojinke.qianxing.train.R;
import taojinke.qianxing.train.base.DaggerFragment;
import taojinke.qianxing.train.dagger.fragments.FragmentComponent;
import taojinke.qianxing.train.events.FragmentReplace;
import taojinke.qianxing.train.ui.train.fragment.base.bean.MajorsIndexBean;
import taojinke.qianxing.train.ui.train.fragment.base.clazz.TrainClassFragment;
import taojinke.qianxing.train.ui.train.fragment.base.first.FirstIntoTrainFragment;
import taojinke.qianxing.train.ui.train.fragment.base.mojor.ChoseMojorFragment;


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
public class BaseTrainFragment extends DaggerFragment implements BaseTrainContract.IBaseTrainView {
    @Inject
    BaseTrainContract.IBaseTrainPresenter mPresenter;
    private FragmentTransaction transaction;

    private FirstIntoTrainFragment firstIntoTrainFragment;
    private ChoseMojorFragment mojorFragment;
    private TrainClassFragment trainClassFragment;

    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.train_fragment_base_train;
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
        FragmentManager fragmentManager = getChildFragmentManager();
        transaction = fragmentManager.beginTransaction();
        RxBus.getInstance().register(this);
        mPresenter.getMajorIndex();
    }

    @Override
    public void doFragmentEvent(MajorsIndexBean majorsIndexBean) {
        if (null == majorsIndexBean) {
            return;
        }
        //第一次进入基础培训
        if (majorsIndexBean.firstStudy) {
            chooseFragment(true, 0);
        } else {
            if (0 != majorsIndexBean.majorId) {
                chooseFragment(false, majorsIndexBean.majorId);
            }
        }
    }

    private void chooseFragment(boolean isFirst, int majorId) {
        if (isFirst) {
            if (null == firstIntoTrainFragment) {
                firstIntoTrainFragment = new FirstIntoTrainFragment();
                transaction.add(R.id.content, firstIntoTrainFragment).commitAllowingStateLoss();
            } else {
                transaction.replace(R.id.content, firstIntoTrainFragment).commitAllowingStateLoss();
            }
        } else {
            if (null == trainClassFragment) {
                trainClassFragment = new TrainClassFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("majorId", majorId);
                trainClassFragment.setArguments(bundle);
                transaction.add(R.id.content, trainClassFragment).commitAllowingStateLoss();
            } else {
                Bundle bundle = new Bundle();
                bundle.putInt("majorId", majorId);
                trainClassFragment.setArguments(bundle);
                transaction.replace(R.id.content, trainClassFragment).commitAllowingStateLoss();
            }
        }
    }

    @RegisterRxBus
    public void fragmentReplace(FragmentReplace fragmentReplace) {
        if (110 == fragmentReplace.getReplace()) {
            if (null == mojorFragment) {
                mojorFragment = new ChoseMojorFragment();
            }
            getChildFragmentManager().beginTransaction().replace(R.id.content, mojorFragment).commitAllowingStateLoss();
        } else {
            if (null == trainClassFragment) {
                trainClassFragment = new TrainClassFragment();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("majorId", fragmentReplace.getReplace());
            bundle.putString("majorTitle", fragmentReplace.getMajorTitle());
            trainClassFragment.setArguments(bundle);
            getChildFragmentManager().beginTransaction().replace(R.id.content, trainClassFragment).commitAllowingStateLoss();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        RxBus.getInstance().unRegister(this);
    }
}
