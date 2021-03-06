package com.sl.entity;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Rest 返回消息
 *
 * @author shulu
 */
@Component
public class RestModel<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public RestModel() {
    }

    public RestModel(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        if (data==null){
            this.data= (T)"";
        }else {
            this.data = data;
        }

    }

    public RestModel(T data) {
        this(HttpStatus.OK.value(), "查询成功", data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
