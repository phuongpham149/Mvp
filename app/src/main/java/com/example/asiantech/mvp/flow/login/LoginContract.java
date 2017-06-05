package com.example.asiantech.mvp.flow.login;

import com.example.asiantech.mvp.base.BasePresenter;

/**
 * Created by asiantech on 02/06/2017.
 */
public interface LoginContract {
    interface view {
        void showProgressBar();

        void hideProgressBar();

        void showError();
    }

    interface presenter extends BasePresenter{
        boolean login(String name,String password);
    }
}
