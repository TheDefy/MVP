package defy.com.mvp.presenter;

import defy.com.mvp.contract.MainActivityContract;

/**
 * Created by chenglei on 2017/10/31.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View mView;

    public MainActivityPresenter(MainActivityContract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void onDestroyPresenter() {

    }
}
