package com.schoolapp.schoolapp.dao;

/**
 * Created by LiCai on 2016/3/6.
 */
public interface HttpCallBackListener {
    void OnFinish(String response);
    void OnError(Exception e);
}
