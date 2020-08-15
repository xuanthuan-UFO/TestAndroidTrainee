package com.xuanthuan.test.model;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    String uname, password;

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

    public boolean checkPassword(){
        String regex = "^(?=.*[0-9])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{6,20}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(getPassword());

        return m.matches();
    }
}
