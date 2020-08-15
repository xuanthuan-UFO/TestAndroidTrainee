package com.xuanthuan.test.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.xuanthuan.test.R;
import com.xuanthuan.test.databinding.ActivityMainBinding;
import com.xuanthuan.test.inter.LoginResult;
import com.xuanthuan.test.model.User;
import com.xuanthuan.test.viewmodel.Login;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
Login login;
ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        login = ViewModelProviders.of(this).get(Login.class);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setLifecycleOwner(this);
        activityMainBinding.setViewmodel(login);

        login.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (TextUtils.isEmpty(Objects.requireNonNull(user).getUname()) ) {
                    activityMainBinding.edtEmail.setError("Nhập Email");
                    activityMainBinding.edtEmail.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(user).getPassword()) ){
                    activityMainBinding.edtPassword.setError("Nhập Password");
                    activityMainBinding.edtPassword.requestFocus();
                } else if (!user.checkPassword()) {
                    activityMainBinding.edtPassword.setError("mật khẩu phải lớn hơn 6 kí tự và có ít nhất 1 chữ số, kí tự đặc biệt");
                    activityMainBinding.edtPassword.requestFocus();
                } else {
                    activityMainBinding.edtEmail.setText(user.getUname());
                    activityMainBinding.edtPassword.setText(user.getPassword());
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, LoginSuccess.class);
                    intent.putExtra("uName", user.getUname());
                    intent.putExtra("password", user.getPassword());
                    startActivity(intent);
                }
            }
        });


    }

}