package com.exfox.gril.domain;

/**
 * 请求返回对象
 */
public class Result<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 返回提示信息
     */
    private String msg;
    /**
     * 返回对象
     */
    private T data;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
