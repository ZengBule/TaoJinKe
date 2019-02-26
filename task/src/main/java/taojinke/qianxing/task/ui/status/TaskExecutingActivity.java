package taojinke.qianxing.task.ui.status;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import taojinke.qianxing.core.ScreenUtils;
import taojinke.qianxing.core.statusbar.StatusBarUtils;
import taojinke.qianxing.lib_kernel.http.net.rx.databus.RegisterRxBus;
import taojinke.qianxing.lib_kernel.http.net.rx.databus.RxBus;
import taojinke.qianxing.task.R;
import taojinke.qianxing.task.base.DaggerActivity;
import taojinke.qianxing.task.dagger.activity.ActivityComponent;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.task.ui.status
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/22+11:00
 * 修改人：
 * 修改时间：2019/2/22+11:00
 * 修改备注：
 * ***********************************************
 */
public class TaskExecutingActivity extends DaggerActivity implements TaskExecutingContract.ITaskExecutingView {
    @Inject
    TaskExecutingContract.ITaskExecutingPresenter mPresenter;
    @BindView(R.id.paddingLine)
    View paddingLine;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.goToMyClass)
    TextView goToMyClass;
    @BindView(R.id.head)
    RelativeLayout head;

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
        StatusBarUtils.with(TaskExecutingActivity.this).init().setStatusTextColor(true, TaskExecutingActivity.this);

        RxBus.getInstance().register(this);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.getStatusHeight(this));
        paddingLine.setLayoutParams(layoutParams);

        haveWaitingCompletData = new HaveWaitingCompletData();
        haveWaitingCompletData.setHaveData("no");
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.task_activity_task_executing;
    }

    private String mStatus = "NoService";

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }


    @RegisterRxBus
    public void setServiceStatusChangeBackground(String status) {
        this.mStatus = status;
        switch (status) {
            case "ReadyForService":

                paddingLine.setBackgroundColor(Color.parseColor("#5B5B5B"));
                head.setBackgroundColor(Color.parseColor("#5B5B5B"));
                back.setImageResource(R.mipmap.icon_back_white);
                break;
            case "NoService":
                paddingLine.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
                head.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
                back.setImageResource(R.mipmap.icon_back_black);
                break;
            case "InService":
                paddingLine.setBackgroundColor(Color.parseColor("#77A9FD"));
                head.setBackgroundColor(Color.parseColor("#77A9FD"));
                back.setImageResource(R.mipmap.icon_back_white);
                break;
            case "PauseService":

                paddingLine.setBackgroundColor(Color.parseColor("#FAAD4B"));
                head.setBackgroundColor(Color.parseColor("#FAAD4B"));
                back.setImageResource(R.mipmap.icon_back_white);
                break;
            case "OutOfService":
                paddingLine.setBackgroundColor(Color.parseColor("#FF6D6D"));
                head.setBackgroundColor(Color.parseColor("#FF6D6D"));
                back.setImageResource(R.mipmap.icon_back_white);
                break;
            default:
                break;
        }
    }

    private HaveWaitingCompletData haveWaitingCompletData;

    @RegisterRxBus
    public void setWaitingCompletTaskHand(HaveWaitingCompletData haveData) {
        this.haveWaitingCompletData = haveData;
        switch (haveData.getHaveData()) {
            case "yes":
                paddingLine.setBackgroundColor(Color.parseColor("#585858"));
                head.setBackgroundColor(Color.parseColor("#585858"));
                back.setImageResource(R.mipmap.icon_back_white);
                break;
            case "no":
                paddingLine.setBackgroundColor(ContextCompat.getColor(TaskExecutingActivity.this, R.color.white));
                head.setBackgroundColor(ContextCompat.getColor(TaskExecutingActivity.this, R.color.white));
                back.setImageResource(R.mipmap.icon_back_black);
                break;
            default:
                break;

        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unRegister(this);
    }

    @OnClick(R.id.goToMyClass)
    public void onViewClassClicked() {
        //lanuchActivity(TaskWaitCompletActivity.class);
    }
}
