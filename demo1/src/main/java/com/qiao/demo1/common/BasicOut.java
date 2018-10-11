package com.qiao.demo1.common;

import java.io.Serializable;

/**
 * @Description TODO
 * @Auther qiaodan
 * @Date 2018/10/10 下午5:32
 * @Version 1.0
 **/
public class BasicOut implements Serializable {
    private String message;
    private Integer returnCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }
}
