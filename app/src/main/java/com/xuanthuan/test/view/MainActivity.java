package com.xuanthuan.test.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.xuanthuan.test.R;
import com.xuanthuan.test.databinding.ActivityMainBinding;
import com.xuanthuan.test.inter.LoginResult;
import com.xuanthuan.test.viewmodel.Login;
import com.xuanthuan.test.viewmodel.LoginFactory;

public class MainActivity extends AppCompatActivity implements LoginResult {
    Login login;
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //activityMainBinding.setLifecycleOwner(this);

        login =new Login(this, getApplicationContext());

        activityMainBinding.setViewmodel(ViewModelProviders.of(
                this,
                new LoginFactory(this, getApplicationContext())
        ).get(Login.class));

    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}