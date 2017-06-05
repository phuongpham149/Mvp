package com.example.asiantech.mvp.flow.login;

import android.util.Log;

/**
 * Created by asiantech on 02/06/2017.
 */
public class LoginPresenter implements LoginContract.presenter {
    private static LoginContract.view mView;

    public LoginPresenter(LoginContract.view view) {
        mView = view;
    }

    @Override
    public boolean login(String username, String password) {
        mView.showProgressBar();
        if (username.equals("phuong") && password.equals("phuong149")) {
            mView.hideProgressBar();
            return true;
        }
        mView.showError();
        return false;
    }

    @Override
    public void start() {
        Log.d(getClass().getSimpleName(), "start presenter");
    }
}
