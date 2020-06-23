package taojinke.qianxing.train.ui.train.fragment.base.mojor;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import taojinke.qianxing.lib_kernel.http.net.rx.RxRestClient;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;
import taojinke.qianxing.train.ui.train.fragment.base.bean.OtherMajorBean;


/**
 * ***********************************************
 * 包路径：taojinke.qianxing.train.ui.train.fragment.base.mojor
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/3/12+17:51
 * 修改人：
 * 修改时间：2019/3/12+17:51
 * 修改备注：
 * ***********************************************
 */
public class ChoseMojorPresenter implements ChoseMojorContract.IChoseMojorPresenter {
    @Inject
    ChoseMojorContract.IChoseMojorView mView;
    private Items majorItems;
    private MultiTypeAdapter adapter;

    @Override
    public void getMajorData() {
        String url = "college/majors/queryMajorList";
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("tjk_login_token", SharedPreferenceUtils.getReqToken(mView.fetchContext()));
        RxRestClient.create()
                .url(url)
                .params(hashMap)
                .build()
                .postQuery()
                .compose(mView.bindLifecycleAndThreadWithLoading())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public MultiTypeAdapter getAdapter() {
        majorItems = new Items();
        adapter = new MultiTypeAdapter(majorItems);
        adapter.register(OtherMajorBean.class, new OtherCourseViewBinder(context));
        return adapter;
    }
}
