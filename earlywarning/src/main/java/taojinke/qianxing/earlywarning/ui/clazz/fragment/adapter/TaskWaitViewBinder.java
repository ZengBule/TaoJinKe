package taojinke.qianxing.earlywarning.ui.clazz.fragment.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;
import taojinke.qianxing.core.DateUtil;
import taojinke.qianxing.core.helper.GlideCircleTransform;
import taojinke.qianxing.earlywarning.R;

/**
 * Created by cc on 2018/11/26.
 */

public class TaskWaitViewBinder extends ItemViewBinder<PlanTaskBean, TaskWaitViewBinder.ViewHolder> {

    private Context mContext;

    public TaskWaitViewBinder(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.task_item_wait, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull PlanTaskBean planTaskBean) {
        holder.llItemPlanTaskTime.setVisibility(View.GONE);
        holder.shopName.setText(TextUtils.isEmpty(planTaskBean.getShopName()) ? "名称未知" : planTaskBean.getShopName());
        holder.hourlyPayTv.setText("¥" + (int) planTaskBean.hourlyPay + "/小时");
        if (0 == getPosition(holder)) {
            holder.itemPoint.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.bg_circle_77a9fd));
        } else {
            holder.itemPoint.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.bg_blue_white));
        }
        String workTimeStr = planTaskBean.getWorkTimeStr();
        if (null != workTimeStr && !"".equals(workTimeStr)) {
            holder.serveTimeTv.setText(workTimeStr);
        } else {
            holder.serveTimeTv.setText("服务时间 未知");
        }
        String missionState = planTaskBean.getMissionState();
        String url = planTaskBean.getShopIconUrl();
        RequestOptions options = new RequestOptions()
                .circleCrop().transforms(new GlideCircleTransform(mContext))
                .error(R.mipmap.icon_photo_personal)
                .placeholder(R.mipmap.icon_photo_personal);
        Glide.with(mContext).load(url).apply(options).into(holder.headImg);
        String time = planTaskBean.getStartTime();
        if (time == null) {
            return;
        }
        try {
            if (planTaskBean.isShowTitle()) {
                holder.llItemPlanTaskTime.setVisibility(View.VISIBLE);
                long timeStamp = DateUtil.getTimeMillion(time);
                boolean isToday = DateUtil.IsToday(timeStamp);
                boolean isTomorrow = DateUtil.IsTomorrowDay(timeStamp);
//                String dateTime = DateUtil.getTime(timeStamp + "", "yyyy年MM月dd日");
                Drawable drawable = mContext.getResources().getDrawable(R.drawable.bg_circle_77a9fd);
//                mTaskTime = dateTime;
                if (isToday) {
                    holder.tvPlanTaskDay.setText("今天");
                    drawable = ContextCompat.getDrawable(mContext, R.drawable.bg_circle_77a9fd);
                    //多少小时后执行第一条任务
                    long currentTime = System.currentTimeMillis();
                    long timeDiff = timeStamp - currentTime;
                    long days = timeDiff / (1000 * 60 * 60 * 24);
                    long hours = (timeDiff - days * 1000 * 60 * 60 * 24) / (1000 * 60 * 60);
                    long minutes = (timeDiff - days * 1000 * 60 * 60 * 24 - hours * 1000 * 60 * 60) / (1000 * 60);
                    if ((int) hours > 0) {
                        holder.serviceTimeHintTv.setText(hours + "小时后执行第一条任务");
                    } else {
                        holder.serviceTimeHintTv.setText(minutes + "分钟后执行第一条任务");
                    }
                } else if (isTomorrow) {
                    holder.tvPlanTaskDay.setText("明天");
                    drawable = ContextCompat.getDrawable(mContext, R.drawable.bg_circle_fffdb077);
                } else {
                    holder.tvPlanTaskDay.setText(DateUtil.getTime(timeStamp + "", "MM月dd日"));
                    drawable = ContextCompat.getDrawable(mContext, R.drawable.bg_circle_ffd5d5d5);
                }
                holder.tvPlanTaskPoint.setImageDrawable(drawable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_plan_task_point)
        ImageView tvPlanTaskPoint;
        @BindView(R.id.tv_plan_task_day)
        TextView tvPlanTaskDay;
        @BindView(R.id.ll_item_plan_task_time)
        RelativeLayout llItemPlanTaskTime;
        @BindView(R.id.headImg)
        ImageView headImg;
        @BindView(R.id.shopName)
        TextView shopName;
        @BindView(R.id.serveTimeTv)
        TextView serveTimeTv;
        @BindView(R.id.hourlyPayTv)
        TextView hourlyPayTv;
        @BindView(R.id.itemPoint)
        ImageView itemPoint;
        @BindView(R.id.serviceTimeHintTv)
        TextView serviceTimeHintTv;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
