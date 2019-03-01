package taojinke.qianxing.earlywarning.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.OnClick;
import taojinke.qianxing.core.ScreenUtils;
import taojinke.qianxing.core.statusbar.StatusBarUtils;
import taojinke.qianxing.earlywarning.R;
import taojinke.qianxing.earlywarning.base.DaggerActivity;
import taojinke.qianxing.earlywarning.dagger.activity.ActivityComponent;
import taojinke.qianxing.earlywarning.ui.clazz.TaskWaitCompletActivity;
import taojinke.qianxing.lib_kernel.http.net.rx.databus.RegisterRxBus;
import taojinke.qianxing.lib_kernel.http.net.rx.databus.RxBus;

import javax.inject.Inject;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.earlywarning.ui
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/28+19:20
 * 修改人：
 * 修改时间：2019/2/28+19:20
 * 修改备注：
 * ***********************************************
 */
public class TaskEcecuterActivity extends DaggerActivity implements TaskEcecuterContract.ITaskEcecuterView {
    @Inject
    TaskEcecuterContract.ITaskEcecuterPresenter mPresenter;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.paddingLine)
    View paddingLine;
    @BindView(R.id.head)
    RelativeLayout head;
    @BindView(R.id.goToMyClass)
    TextView goToMyClass;


    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
        StatusBarUtils.with(TaskEcecuterActivity.this).init().setStatusTextColor(true, TaskEcecuterActivity.this);

        RxBus.getInstance().register(this);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.getStatusHeight(this));
        paddingLine.setLayoutParams(layoutParams);

        haveWaitingCompletData = new HaveWaitingCompletData();
        haveWaitingCompletData.setHaveData("no");
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.task_activity_executing;
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
                paddingLine.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
                head.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
                back.setImageResource(R.mipmap.icon_back_black);
                break;
            default:

        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unRegister(this);
    }

    @OnClick(R.id.goToMyClass)
    public void onViewClassClicked() {
        lanuchActivity(TaskWaitCompletActivity.class);
    }
}
