package com.xuanthuan.test.inter;

import java.util.Observable;

public interface LoginResult {
    void onSuccess(String message);
    void onError(String message);

    void update(Observable o, Object arg);
}
