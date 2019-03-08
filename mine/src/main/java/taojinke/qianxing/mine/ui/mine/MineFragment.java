package taojinke.qianxing.mine.ui.mine;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import taojinke.qianxing.lib_kernel.model.LoginUserBean;
import taojinke.qianxing.mine.R;
import taojinke.qianxing.mine.base.DaggerFragment;
import taojinke.qianxing.mine.dagger.fragment.FragmentComponent;
import taojinke.qianxing.mine.modle.UserBean;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.mine.ui.mine
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/21+14:52
 * 修改人：
 * 修改时间：2019/2/21+14:52
 * 修改备注：
 * ***********************************************
 */
@Route(path = "/mine/fragment")
public class MineFragment extends DaggerFragment implements MineContract.IMineView {
    @Inject
    MineContract.IMinePresenter mPresenter;
    @BindView(R.id.iv_mine_header)
    ImageView ivMineHeader;
    @BindView(R.id.tv_mine_name)
    TextView tvMineName;
    @BindView(R.id.iv_mine_identification)
    ImageView ivMineIdentification;
    @BindView(R.id.tv_mine_identification)
    TextView tvMineIdentification;
    @BindView(R.id.iv_mine_document)
    ImageView ivMineDocument;
    @BindView(R.id.tv_mine_document)
    TextView tvMineDocument;
    @BindView(R.id.cons_mine_header)
    ConstraintLayout consMineHeader;
    @BindView(R.id.balanceTv)
    TextView balanceTv;
    @BindView(R.id.earningsTv)
    TextView earningsTv;
    @BindView(R.id.ll_mine_wallet)
    LinearLayout llMineWallet;
    @BindView(R.id.serviceHourTv)
    TextView serviceHourTv;
    @BindView(R.id.ll_service_data)
    LinearLayout llServiceData;
    @BindView(R.id.tv_badge_numbers)
    TextView tvBadgeNumbers;
    @BindView(R.id.ll_mine_badge)
    LinearLayout llMineBadge;
    @BindView(R.id.ll_taojin_level)
    LinearLayout llTaojinLevel;
    @BindView(R.id.ll_mine_training)
    LinearLayout llMineTraining;
    @BindView(R.id.ll_mine_service)
    LinearLayout llMineService;
    @BindView(R.id.ll_mine_service_before)
    LinearLayout llMineServiceBefore;
    @BindView(R.id.tv_mine_times)
    TextView tvMineTimes;
    @BindView(R.id.ll_mine_get)
    LinearLayout llMineGet;
    @BindView(R.id.arrow)
    ImageView arrow;
    @BindView(R.id.tvMineMyClass)
    TextView tvMineMyClass;
    @BindView(R.id.rl_wo_de_class)
    RelativeLayout rlWoDeClass;
    @BindView(R.id.ll_mine_service_shop)
    LinearLayout llMineServiceShop;
    @BindView(R.id.ll_mine_my_class)
    LinearLayout llMineMyClass;
    @BindView(R.id.ll_mine_plan)
    LinearLayout llMinePlan;
    @BindView(R.id.ll_mine_book)
    LinearLayout llMineBook;
    @BindView(R.id.ll_mine_complete)
    LinearLayout llMineComplete;
    @BindView(R.id.ll_mine_recruit)
    LinearLayout llMineRecruit;
    @BindView(R.id.ll_mine_help)
    LinearLayout llMineHelp;
    @BindView(R.id.ivMineNews)
    ImageView ivMineNews;
    @BindView(R.id.tv_home_unread)
    TextView tvHomeUnread;
    @BindView(R.id.customName)
    TextView customName;
    @BindView(R.id.ivMineScan)
    ImageView ivMineScan;
    @BindView(R.id.ll_mine_sit)
    ImageView llMineSit;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private UserBean mUserBean;


    @Override
    protected void inject(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutResources() {
        return R.layout.mine_fragment_mine;
    }

    @Override
    protected void trySetupData(Bundle savedInstanceState) {

    }
}
