package com.xuanthuan.test.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.xuanthuan.test.inter.LoginResult;
import com.xuanthuan.test.model.User;

public class Login extends ViewModel {
    Context context;
LoginResult loginResult;
User user;
    private boolean check_box;
String KEY_email = "email";
String KEY_password = "password";

    public MutableLiveData<String> uName = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    public Login(LoginResult loginResult, Context context) {
        this.context = context;
        this.loginResult = loginResult;
        this.user = new User();
        user.setUname(getSpuName());
        user.setPassword(getSpPassword());
    }

    public void onCheckedChange(CompoundButton button, boolean check) {
        check_box = check;
    }

    public void clickLogin(View view){
        user = new User(uName.getValue(), password.getValue());

        Log.d("thuan", "clickLogin: " + user.getUname() + user.getPassword());
//        userMutableLiveData.setValue(user);
        int checkAcount = user.checkPassword(context);

        if (checkAcount == 0) {
            loginResult.onError("Bạn vui lòng nhập địa chỉ email");
        } else if (checkAcount == 1) {
            loginResult.onError("Vui lòng nhập mật khẩu");
        } else if (checkAcount == 2) {
            loginResult.onError("Bạn nhậ email sai định dạng");
        } else if (checkAcount == 3) {
            loginResult.onError("Mật khẩu > 6 ký tự gồm ít nhất 1 tự đặc biệt, 1 chữ số");
        } else {
            loginResult.onSuccess("Đăng nhập thành công");

            SharedPreferences preferences = context.getSharedPreferences("Account", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            if (check_box) {
                editor.putString(KEY_email, user.getUname());
                editor.putString(KEY_password, user.getPassword());
            } else {
                editor.clear();
            }
            editor.apply();
        }
    }

    public String getSpuName() {
        SharedPreferences preferences = context.getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
        return preferences.getString(KEY_email, "");
    }

    public String getSpPassword() {
        SharedPreferences preferences = context.getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
        return preferences.getString(KEY_password, "");
    }


}
