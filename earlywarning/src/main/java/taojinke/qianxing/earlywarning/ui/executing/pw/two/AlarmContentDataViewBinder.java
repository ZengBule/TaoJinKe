package taojinke.qianxing.earlywarning.ui.executing.pw.two;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;
import taojinke.qianxing.earlywarning.R;


public class AlarmContentDataViewBinder extends ItemViewBinder<AlarmContentDataIncludeView, AlarmContentDataViewBinder.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.task_item_alarm_content_data, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull AlarmContentDataIncludeView data) {

        AlarmContentData alarmContentData = data.getData();

        holder.countdownViewLayout.removeAllViews();
        holder.countdownViewLayout.addView(data.getCountdownView());
        holder.shopName.setText(alarmContentData.getShopName());

        holder.type.setText(alarmContentData.getWarningAbstract());

        holder.alarmStatus.setText(alarmContentData.getWarningState());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.countdownViewLayout)
        LinearLayout countdownViewLayout;
        @BindView(R.id.type)
        TextView type;
        @BindView(R.id.shopName)
        TextView shopName;

        @BindView(R.id.alarmStatus)
        TextView alarmStatus;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
