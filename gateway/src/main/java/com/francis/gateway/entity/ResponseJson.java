package com.francis.gateway.entity;

import lombok.Data;

/**
 * @author: francis
 * @description:
 * @date: 2020/7/12 17:20
 */
@Data
public class ResponseJson<T> {

    private int code;

    private String msg;

    private T data;

    public ResponseJson() {}

    public ResponseJson(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
