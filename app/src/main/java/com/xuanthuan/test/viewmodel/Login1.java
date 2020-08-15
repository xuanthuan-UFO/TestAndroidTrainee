package com.xuanthuan.test.viewmodel;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.xuanthuan.test.inter.LoginResult;
import com.xuanthuan.test.model.User;

public class Login1 extends ViewModel {

    private String uNmme;
    private String password;
    private LoginResult loginResult;

    public Login1() {
    }



    public void clickLogin(View view){
        Log.d("thuan", "clickLogin: " + uNmme + password);
        if ((uNmme != null) || (password != null)) {
            User user = new User(uNmme, password);
            if (user.checkPassword()) {
                loginResult.onSuccess("OK");
            } else {
                loginResult.onError("Error");
            }
        }

    }
}
