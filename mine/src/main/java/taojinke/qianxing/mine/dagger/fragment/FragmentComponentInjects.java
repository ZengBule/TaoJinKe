package taojinke.qianxing.mine.dagger.fragment;

import taojinke.qianxing.mine.ui.main.MainActivity;
import taojinke.qianxing.mine.ui.main.MainPresenter;
import taojinke.qianxing.mine.ui.mine.MineFragment;
import taojinke.qianxing.mine.ui.mine.MinePresenter;

public interface FragmentComponentInjects {
    void inject(MinePresenter presenter);

    void inject(MineFragment fragment);


}
