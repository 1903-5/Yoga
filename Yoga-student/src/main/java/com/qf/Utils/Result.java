package com.qf.Utils;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 8676131899637805509L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    // 返回编码
    private String code;
    // 返回信息
    private String msg;
    // 返回数据封装
    private T data;


}
