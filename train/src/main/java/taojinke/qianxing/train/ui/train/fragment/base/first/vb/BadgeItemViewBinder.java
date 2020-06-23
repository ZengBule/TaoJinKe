package taojinke.qianxing.train.ui.train.fragment.base.first.vb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;
import taojinke.qianxing.core.helper.GlideCircleTransform;
import taojinke.qianxing.train.R;

/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.basetrain.childbasetrain.first.adapter
 * 类描述：
 * 创建人：杨延辉[PHONE：15281087434]
 * 创建时间：2019/2/19+10:50
 * 修改人：
 * 修改时间：2019/2/19+10:50
 * 修改备注：
 * ***********************************************
 */
public class BadgeItemViewBinder extends ItemViewBinder<BadgeListBean, BadgeItemViewBinder.ViewHolder> {

    Context context;


    public BadgeItemViewBinder(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.train_item_first_base_train_badge, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BadgeListBean item) {
        RequestOptions options = new RequestOptions()
                .circleCrop().transforms(new GlideCircleTransform(context))
                .error(R.mipmap.app_icon)
                .placeholder(R.mipmap.app_icon);
        Glide.with(context).load(item.iconUrl).apply(options).into(holder.badgeImg);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.badgeImg)
        ImageView badgeImg;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
