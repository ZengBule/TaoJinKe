package taojinke.qianxing.earlywarning.ui.alarm;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import javax.inject.Inject;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import taojinke.qianxing.earlywarning.R;
import taojinke.qianxing.earlywarning.base.DaggerActivity;
import taojinke.qianxing.earlywarning.dagger.activity.ActivityComponent;


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
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.rightText)
    TextView rightText;
    @BindView(R.id.typeOne)
    TextView typeOne;
    @BindView(R.id.layoutTypeOne)
    RelativeLayout layoutTypeOne;
    @BindView(R.id.typeTwo)
    TextView typeTwo;
    @BindView(R.id.layoutTypeTwo)
    RelativeLayout layoutTypeTwo;
    @BindView(R.id.typeThree)
    TextView typeThree;
    @BindView(R.id.layoutTypeThree)
    RelativeLayout layoutTypeThree;
    @BindView(R.id.mustTypeOne)
    TextView mustTypeOne;
    @BindView(R.id.layoutMustTypeOne)
    RelativeLayout layoutMustTypeOne;
    @BindView(R.id.mustTypeTwo)
    TextView mustTypeTwo;
    @BindView(R.id.layoutMustTypeTwo)
    RelativeLayout layoutMustTypeTwo;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.remark)
    EditText remark;
    @BindView(R.id.scroll)
    NestedScrollView scroll;
    @BindView(R.id.commit)
    TextView commit;

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
