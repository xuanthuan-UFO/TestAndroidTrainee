package com.xuanthuan.test.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.xuanthuan.test.inter.LoginResult;

public class LoginFactory extends ViewModelProvider.NewInstanceFactory {
private LoginResult loginResult;
private Context context;

    public LoginFactory(LoginResult loginResult, Context context) {
        this.loginResult = loginResult;
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new Login(loginResult, context);
    }
}
