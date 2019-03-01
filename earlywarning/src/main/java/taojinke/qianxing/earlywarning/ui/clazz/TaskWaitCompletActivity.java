package taojinke.qianxing.earlywarning.ui.clazz;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.OnClick;
import taojinke.qianxing.core.statusbar.StatusBarUtils;
import taojinke.qianxing.earlywarning.R;
import taojinke.qianxing.earlywarning.base.DaggerActivity;
import taojinke.qianxing.earlywarning.dagger.activity.ActivityComponent;

import javax.inject.Inject;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.earlywarning.ui.clazz
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/1+10:05
 * 修改人：
 * 修改时间：2019/3/1+10:05
 * 修改备注：
 * ***********************************************
 */
public class TaskWaitCompletActivity extends DaggerActivity implements TaskWaitCompletContract.ITaskWaitCompletView {
    @Inject
    TaskWaitCompletContract.ITaskWaitCompletPresenter mPresenter;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {
        StatusBarUtils.with(this)
                .setColor(Color.parseColor("#FFFFFFFE"))
                .init()
                .setStatusTextColorAndPaddingTop(true, this);

        title.setText("待完成");
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.early_warning_activity_wait_complet;
    }
    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
