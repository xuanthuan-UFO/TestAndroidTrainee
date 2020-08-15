package com.xuanthuan.test.viewmodel;

import android.content.SharedPreferences;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.xuanthuan.test.inter.LogoutResult;

import static android.content.Context.MODE_PRIVATE;

public class Logout extends ViewModel {

    LogoutResult logoutResult;

    public Logout(LogoutResult logoutResult) {
        this.logoutResult = logoutResult;
    }

    public void onClick(View view){
        logoutResult.Logout("đăng xuất");
        SharedPreferences sharedPreferences = view.getContext().getSharedPreferences("Account", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        editor.apply();
    }
}
