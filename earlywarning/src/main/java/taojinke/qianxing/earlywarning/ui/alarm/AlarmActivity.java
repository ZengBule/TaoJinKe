package taojinke.qianxing.earlywarning.ui.alarm;

import android.os.Bundle;

import taojinke.qianxing.earlywarning.R;
import taojinke.qianxing.earlywarning.base.DaggerActivity;
import taojinke.qianxing.earlywarning.dagger.activity.ActivityComponent;

import javax.inject.Inject;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.earlywarning.ui.alarm
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/1+10:36
 * 修改人：
 * 修改时间：2019/3/1+10:36
 * 修改备注：
 * ***********************************************
 */
public class AlarmActivity extends DaggerActivity implements AlarmContract.IAlarmView {
    @Inject
    AlarmContract.IAlarmPresenter mPresenter;

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.task_activity_alarm_layout;
    }
}
