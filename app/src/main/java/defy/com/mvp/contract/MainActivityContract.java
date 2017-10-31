package defy.com.mvp.contract;

import defy.com.mvp.base.IBasePresenter;
import defy.com.mvp.base.IBaseView;

/**
 * Created by chenglei on 2017/10/31.
 */

public interface MainActivityContract {
    interface View extends IBaseView<Presenter>{

    }

    interface Presenter extends IBasePresenter{

    }
}
