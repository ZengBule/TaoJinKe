package taojinke.qianxing.earlywarning.ui.executing.store;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;
import taojinke.qianxing.earlywarning.R;
import taojinke.qianxing.earlywarning.ui.alarm.AlarmActivity;


public class AlarmInfoViewBinder extends ItemViewBinder<AlarmInfo, AlarmInfoViewBinder.ViewHolder> {


    private Context mContext;

    public AlarmInfoViewBinder(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.task_item_alarm_info, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull AlarmInfo alarmInfo) {
        if (alarmInfo.isPutOn()) {
            holder.content.setVisibility(View.VISIBLE);
            holder.commitWarning.setVisibility(View.GONE);
        } else {
            holder.content.setVisibility(View.GONE);
            holder.commitWarning.setVisibility(View.VISIBLE);
        }

        holder.commitWarning.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, AlarmActivity.class);
            mContext.startActivity(intent);
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.commitWarning)
        TextView commitWarning;

        @BindView(R.id.content)
        TextView content;

        ViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }
}
