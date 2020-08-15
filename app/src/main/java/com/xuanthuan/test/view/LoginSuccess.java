package com.xuanthuan.test.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.xuanthuan.test.R;
import com.xuanthuan.test.databinding.ActivityMainBinding;
import com.xuanthuan.test.inter.LogoutResult;

public class LoginSuccess extends AppCompatActivity implements LogoutResult {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_success);

        /*
        activityMainBinding.setViewmodel(ViewModelProviders.of(
                this,
                new LogoutlFactory(this)
        ).get(Logout.class));
        */
    }


    @Override
    public void Logout(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}