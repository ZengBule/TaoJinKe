package taojinke.qianxing.earlywarning.ui.rule.vb.rule.cvb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;
import taojinke.qianxing.earlywarning.R;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.taskstatus.alarmRuler.vb.rule.cvb
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2018/12/19+15:32
 * 修改人：
 * 修改时间：2018/12/19+15:32
 * 修改备注：
 * ***********************************************
 */
public class RuleContentViewBinder extends ItemViewBinder<RuleContent, RuleContentViewBinder.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.task_alarm_item_report_content, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull RuleContent ruleContent) {
        holder.tvTimePart.setText(ruleContent.getDuration());
        holder.tvRuleContent.setText(ruleContent.getHandleRule());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_time_part)
        TextView tvTimePart;
        @BindView(R.id.tv_rule_content)
        TextView tvRuleContent;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
