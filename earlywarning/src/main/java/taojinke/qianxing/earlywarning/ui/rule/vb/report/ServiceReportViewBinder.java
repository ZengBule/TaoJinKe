package taojinke.qianxing.earlywarning.ui.rule.vb.report;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import taojinke.qianxing.core.DensityUtil;
import taojinke.qianxing.core.ScreenUtils;
import taojinke.qianxing.earlywarning.R;
import taojinke.qianxing.earlywarning.ui.rule.vb.report.cvb.ServiceReportContent;
import taojinke.qianxing.earlywarning.ui.rule.vb.report.cvb.ServiceReportContentViewBinder;
import taojinke.qianxing.lib_weight.AtMostRecyclerView;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.taskstatus.alarmRuler.vb.report
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2018/12/19+15:19
 * 修改人：
 * 修改时间：2018/12/19+15:19
 * 修改备注：
 * ***********************************************
 */
public class ServiceReportViewBinder extends ItemViewBinder<ServiceReport.ReportCardListBean, ServiceReportViewBinder.ViewHolder> {

    private Context mContext;

    public ServiceReportViewBinder(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.task_alarm_item_service_report, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ServiceReport.ReportCardListBean serviceReport) {

        int width = ScreenUtils.getScreenWidth(mContext);
        float density = ScreenUtils.getScreenDensity(mContext);

        int itemWidth = (int) (width - density * 43);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(itemWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, DensityUtil.dip2px(mContext, 10), 0);
        holder.llItemView.setLayoutParams(layoutParams);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        holder.recycle.setLayoutManager(linearLayoutManager);
        Items items = new Items();
        items.addAll(serviceReport.getHandleItemList());
        MultiTypeAdapter adapter = new MultiTypeAdapter(items);
        adapter.register(ServiceReportContent.class, new ServiceReportContentViewBinder());

        holder.recycle.setAdapter(adapter);

        holder.title.setText(serviceReport.getTitle());
        holder.subject.setText(serviceReport.getStandard());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.subject)
        TextView subject;
        @BindView(R.id.recycle)
        AtMostRecyclerView recycle;
        @BindView(R.id.ll_item_view)
        LinearLayout llItemView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
