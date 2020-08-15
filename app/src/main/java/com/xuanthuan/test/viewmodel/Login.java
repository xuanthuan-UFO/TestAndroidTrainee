package com.xuanthuan.test.viewmodel;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.xuanthuan.test.R;
import com.xuanthuan.test.inter.LoginResult;
import com.xuanthuan.test.model.User;

public class Login extends ViewModel {

    public MutableLiveData<String> uName = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    private MutableLiveData<User> userMutableLiveData;

    public MutableLiveData<User> getUser(){
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }


    public void clickLogin(View view){
        User user = new User(uName.getValue(), password.getValue());
        Log.d("thuan", "clickLogin: " + user.getUname() + user.getPassword());
        userMutableLiveData.setValue(user);

    }
}
