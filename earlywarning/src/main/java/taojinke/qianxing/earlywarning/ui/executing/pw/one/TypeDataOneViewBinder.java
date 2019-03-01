package taojinke.qianxing.earlywarning.ui.executing.pw.one;

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
import taojinke.qianxing.lib_kernel.http.net.rx.databus.RxBus;


public class TypeDataOneViewBinder extends ItemViewBinder<TypeDataOne, TypeDataOneViewBinder.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.task_item_type_data_one, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull TypeDataOne typeDataOne) {
        holder.num.setText(String.valueOf(typeDataOne.getValue()));
        holder.clickSpread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               RxBus.getInstance().send(new Dismiss());
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.num)
        TextView num;
        @BindView(R.id.clickSpread)
        TextView clickSpread;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
