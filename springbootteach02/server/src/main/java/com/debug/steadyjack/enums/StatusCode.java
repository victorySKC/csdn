package com.debug.steadyjack.enums;

/**
 * Created by steadyjack on 2018/9/6.
 */
public enum StatusCode {

    Success(0,"成功"),
    Fail(-1,"失败"),
    Entity_Not_Exist(110,"实体信息不存在");

    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}
