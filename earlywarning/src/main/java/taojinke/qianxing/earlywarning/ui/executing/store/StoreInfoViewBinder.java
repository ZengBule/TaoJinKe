package taojinke.qianxing.earlywarning.ui.executing.store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;
import taojinke.qianxing.earlywarning.R;


public class StoreInfoViewBinder extends ItemViewBinder<StoreInfoIncludeView, StoreInfoViewBinder.ViewHolder> {


    public StoreInfoViewBinder(Context mContext) {
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.task_executing_item_store_info, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull StoreInfoIncludeView data) {

        StoreInfo storeInfo = data.getStoreInfo();
        if (holder.countdownLayout.getChildCount() > 1) {
            holder.countdownLayout.removeViewAt(1);
        }
        holder.countdownLayout.addView(data.getCountdownView());
        holder.name.setText(storeInfo.getShopName());

        holder.price.setText("¥");
        holder.price.append(String.valueOf((int) storeInfo.getHourlyPay()));
        holder.price.append("元/小时");

        holder.servicePartTime.setText("服务时间  ");
        holder.servicePartTime.append(storeInfo.getSchedulingTime());

        holder.predictIncome.setText("预计收益：  ¥");
        holder.predictIncome.append(String.valueOf((int) storeInfo.getEarning()));

    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.countdownLayout)
        LinearLayout countdownLayout;
        @BindView(R.id.showLogo)
        ImageView showLogo;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.servicePartTime)
        TextView servicePartTime;
        @BindView(R.id.storeReward)
        ImageView storeReward;
        @BindView(R.id.reward)
        TextView reward;
        @BindView(R.id.comment)
        TextView comment;
        @BindView(R.id.predictIncome)
        TextView predictIncome;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
