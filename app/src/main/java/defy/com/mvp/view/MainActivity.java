package defy.com.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import defy.com.mvp.contract.MainActivityContract;

/**
 * Created by chenglei on 2017/10/31.
 */

public class MainActivity extends Activity implements MainActivityContract.View{

    private MainActivityContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void setPresenter(MainActivityContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public Context getContext() {
        return this;
    }
}
