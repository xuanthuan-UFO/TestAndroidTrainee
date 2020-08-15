package com.xuanthuan.test.inter;

public interface LoginResult {
    void onSuccess(String message);
    void onError(String message);
}
