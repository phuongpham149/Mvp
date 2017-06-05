package com.example.asiantech.mvp.flow.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.asiantech.mvp.R;
import com.example.asiantech.mvp.flow.home.HomeActivity;

/**
 * Created by asiantech on 02/06/2017.
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.view {
    private LoginPresenter mPresenter;

    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private ImageView mImgNext;
    private ProgressBar mProgressBarLoading;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(getClass().getSimpleName(), "start");
        mPresenter = new LoginPresenter(this);
        init();
        mImgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent ;
                if(mPresenter.login(mEdtUsername.getText().toString(), mEdtPassword.getText().toString())){
                    intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void init() {
        mEdtUsername = (EditText) findViewById(R.id.edtUsername);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);
        mImgNext = (ImageView) findViewById(R.id.imgNext);
        mProgressBarLoading = (ProgressBar) findViewById(R.id.progressBarLoading);
    }

    @Override
    public void showProgressBar() {
        mProgressBarLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBarLoading.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        Toast.makeText(LoginActivity.this,"error",Toast.LENGTH_SHORT).show();
        mProgressBarLoading.setVisibility(View.GONE);
    }
}
