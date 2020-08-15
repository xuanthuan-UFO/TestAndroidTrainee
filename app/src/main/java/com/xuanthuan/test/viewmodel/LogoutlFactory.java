package com.xuanthuan.test.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.xuanthuan.test.inter.LogoutResult;

public class LogoutlFactory extends ViewModelProvider.NewInstanceFactory {
    private LogoutResult logoutResult;

    public LogoutlFactory(LogoutResult logoutResult) {
        this.logoutResult = logoutResult;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new Logout(logoutResult);
    }
}
