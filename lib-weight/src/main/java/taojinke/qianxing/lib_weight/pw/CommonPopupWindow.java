package taojinke.qianxing.lib_weight.pw;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import qianxing.taojinke.R;
import qianxing.taojinke.Utils.DensityUtil;
import qianxing.taojinke.Utils.DispatchEventRecyclerView;
import qianxing.taojinke.Utils.ScreenUtils;
import qianxing.taojinke.ui.taskstatus.executing.fragments.executing.pw.one.Dismiss;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;


public class CommonPopupWindow extends PopupWindow {

    @BindView(R.id.recycle)
    DispatchEventRecyclerView recycle;
    @BindView(R.id.cancel)
    RelativeLayout cancel;
    private Context mContext;
    private Items items;
    private MultiTypeAdapter adapter;
    private Location mLocation;

    public enum Location {
        CENTER, BOTTOM, TOP

    }


    public CommonPopupWindow(Context context, ArrayList<Class> clazzs, ArrayList<ItemViewBinder> binders) {
        super(context);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.mContext = context;
        items = new Items();
        adapter = new MultiTypeAdapter(items);
        for (int i = 0; i < clazzs.size(); i++) {
            adapter.register(clazzs.get(i), binders.get(i));
        }
        EventBus.getDefault().register(this);
    }

    public CommonPopupWindow initView(Location location) {
        mLocation = location;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = null;
        switch (location.name()) {
            case "BOTTOM":
                this.setAnimationStyle(R.style.mypopwindow_anim_style);
                view = inflater.inflate(R.layout.common_popup_window_layout, null, false);
                break;
            case "CENTER":
                this.setAnimationStyle(R.style.mypopwindow_anim_style);
                view = inflater.inflate(R.layout.common_popup_window_layout_center, null, false);
                break;
            case "TOP":
                view = inflater.inflate(R.layout.common_popup_window_layout_top, null, false);
                this.setHeight(ScreenUtils.getScreenHeight(mContext) - ScreenUtils.getStatusHeight(mContext) - DensityUtil.dip2px(mContext, 96));
                break;
        }

        ButterKnife.bind(this, view);
        LinearLayout.LayoutParams layoutParams;
        if (TextUtils.equals("TOP", location.name())) {
            layoutParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        } else {
            layoutParams = new LinearLayout.LayoutParams(MATCH_PARENT, ScreenUtils.getScreenHeight(mContext) / 3 * 2);
        }
        recycle.setLayoutParams(layoutParams);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setSmoothScrollbarEnabled(false);

        recycle.setLayoutManager(linearLayoutManager);
        recycle.setAdapter(adapter);
        recycle.setOnClickListener(v -> dismiss());
        setContentView(view);
        return this;
    }

    public CommonPopupWindow setAdapter(Items list) {

        if (TextUtils.equals("TOP", mLocation.name())) {
            LinearLayout.LayoutParams layoutParams;
            if (list.size() <= 5) {
                layoutParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
            } else {
                layoutParams = new LinearLayout.LayoutParams(MATCH_PARENT, ScreenUtils.getScreenHeight(mContext) / 2);
            }
            recycle.setLayoutParams(layoutParams);
        }

        items.clear();
        items.addAll(list);
        adapter.notifyDataSetChanged();
        return this;
    }

    public void showWindow(View view, int gravity) {
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable(0x45000000);
        this.setBackgroundDrawable(dw);
        this.showAtLocation(view, gravity, 0, 0);
    }

    public void showWindowRlatLocaton(View view, float y) {
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable(0x50000000);
        this.setBackgroundDrawable(dw);
        this.showAsDropDown(view, 0, (int) y);
    }

    @Subscribe
    public void onDissmizz(Dismiss dismiss) {
        this.dismiss();
    }


    @OnClick(R.id.cancel)
    public void onViewClicked() {
        dismiss();
    }
}
