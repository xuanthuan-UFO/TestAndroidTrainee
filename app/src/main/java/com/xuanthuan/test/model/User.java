package com.xuanthuan.test.model;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User {
    String uname, password;
    boolean check;

    public User() {
    }

    public User(String uname, String password) {
        this.uname = uname;
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int checkPassword(Context context){
        String regex = "^(?=.*[0-9])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{6,20}$";


        if (TextUtils.isEmpty(getUname())) {
            return 0;
        } else if (TextUtils.isEmpty(getPassword())) {
            return 1;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(getUname()).matches()) {
            return 2;
        } else if (!Pattern.compile(regex).matcher(getPassword()).matches()) {
            return 3;
        } else {
            return -1;
        }
    }
}
