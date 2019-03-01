package taojinke.qianxing.earlywarning.ui.rule;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import taojinke.qianxing.core.statusbar.StatusBarUtils;
import taojinke.qianxing.earlywarning.R;
import taojinke.qianxing.earlywarning.base.DaggerActivity;
import taojinke.qianxing.earlywarning.dagger.activity.ActivityComponent;

import javax.inject.Inject;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.earlywarning.ui.rule
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/1+16:27
 * 修改人：
 * 修改时间：2019/3/1+16:27
 * 修改备注：
 * ***********************************************
 */
public class AlarmRulerAndSpeackActivity extends DaggerActivity implements AlarmRulerAndSpeackContract.IAlarmRulerAndSpeackView {
    @Inject
    AlarmRulerAndSpeackContract.IAlarmRulerAndSpeackPresenter mPresenter;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.recycleRuler)
    RecyclerView recycleRuler;
    @BindView(R.id.recycleService)
    RecyclerView recycleService;

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
        StatusBarUtils.with(this)
                .setColor(R.color.white)
                .init();


        initRuleRecycleView();
        initServiceReportRecycleView();
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.task_activity_alarm_ruler_and_speack;
    }

    /**
     * 预警规则和说明控件初始化
     */
    private void initRuleRecycleView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recycleRuler.setLayoutManager(linearLayoutManager);
        recycleRuler.setAdapter(mPresenter.getAlarmRuleSpeakAdapter());
        mPresenter.getAlarmRuleSpeak();

    }

    /**
     * 初始服务报备
     */
    private void initServiceReportRecycleView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recycleService.setLayoutManager(linearLayoutManager);
        recycleService.setAdapter(mPresenter.getServiceReportAdapter());
        mPresenter.getServiceReport();

    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
