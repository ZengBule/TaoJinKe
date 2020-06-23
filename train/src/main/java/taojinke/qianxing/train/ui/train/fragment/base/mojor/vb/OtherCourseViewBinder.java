package taojinke.qianxing.train.ui.train.fragment.base.mojor.vb;

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
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import taojinke.qianxing.lib_weight.ProGrossCircleView;
import taojinke.qianxing.train.R;
import taojinke.qianxing.train.ui.train.fragment.base.first.vb.BadgeItemViewBinder;
import taojinke.qianxing.train.ui.train.fragment.base.first.vb.BadgeListBean;


/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.basetrain.childbasetrain.first
 * 类描述：
 * 创建人：杨延辉[PHONE：15281087434]
 * 创建时间：2019/2/18+16:34
 * 修改人：
 * 修改时间：2019/2/18+16:34
 * 修改备注：
 * ***********************************************
 */
public class OtherCourseViewBinder extends ItemViewBinder<OtherMajorBean, OtherCourseViewBinder.ViewHolder> {

    private Context context;
    private Items items;
    private MultiTypeAdapter adapter;

    public OtherCourseViewBinder(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.train_item_other_course, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull OtherMajorBean otherMajorBean) {
        holder.nameTv.setText(otherMajorBean.majorTitle);
        holder.moneyTv.setText(otherMajorBean.passAveragePay + "元");
        items = new Items();
        items.addAll(otherMajorBean.badgeList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.badgeRecycle.setLayoutManager(linearLayoutManager);
        adapter = new MultiTypeAdapter(items);
        adapter.register(BadgeListBean.class, new BadgeItemViewBinder(context));
        holder.badgeRecycle.setAdapter(adapter);

        holder.completeProgress.setScore(otherMajorBean.currentProgress);
        final int currentProgress = otherMajorBean.currentProgress;
        new Thread(() -> {
            if (currentProgress > 0) {
                for (int i = 1; i <= currentProgress; i++) {
                    holder.completeProgress.setScore(i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                holder.completeProgress.setScore(0);
            }
        }).start();

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  EventBus.getDefault().post(new EventTags.fragmentReplace(otherMajorBean.majorId, otherMajorBean.majorTitle));
            }
        });

    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nameTv)
        TextView nameTv;
        @BindView(R.id.moneyTv)
        TextView moneyTv;
        @BindView(R.id.completeProgress)
        ProGrossCircleView completeProgress;
        @BindView(R.id.badgeRecycle)
        RecyclerView badgeRecycle;
        @BindView(R.id.itemLayout)
        LinearLayout itemLayout;

        ViewHolder(View itemView) {
            super(itemView);
            //ButterKnife.bind(this, itemView);

        }
    }
}
