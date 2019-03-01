package taojinke.qianxing.earlywarning.ui.executing.pw.three;


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

public class RediuceAlarmViewBinder extends ItemViewBinder<RediuceAlarm, RediuceAlarmViewBinder.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.task_item_rediuce_alarm, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull RediuceAlarm rediuceAlarm) {
//        holder.hintText.setText("待确认预警");
//        holder.hintText.append(String.valueOf(rediuceAlarm.getVlaue()));
//        holder.hintText.append("条,");
//        holder.hintText.append("请在电脑上确认并及时处理");

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.hintText)
        TextView hintText;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
