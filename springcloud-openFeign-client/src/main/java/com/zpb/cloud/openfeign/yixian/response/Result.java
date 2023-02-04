package com.zpb.cloud.openfeign.yixian.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author       pengbo.zhao
 * @description  响应体
 * @createDate   2022/9/21 14:18
 * @updateDate   2022/9/21 14:18
 * @version      1.0
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -7495753461536663749L;

    /**
     * code码
     */
    private Integer code;

    /**
     * 状态码
     */
    private String status;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 返回结果
     */
    private T data;

    public static final int ZERO = 0;
    public static final int SUCCESS_CODE = 200;
    public static final int ERROR_CODE = 500;
    public static final String STATUS_SUCCESS = "success";
    public static final String STATUS_ERROR = "error";
    public static final String ERROR_MSG = "失败";


    public Result(Integer code, String status, String msg, T data){
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> ok(Integer code, String status, String msg,T data){
        return new Result<>(code, status, msg, data);
    }

    public static <T> Result<T> ok(){
        return ok(SUCCESS_CODE,STATUS_SUCCESS,STATUS_SUCCESS,null);
    }

    public static <T> Result<T> ok(T data){
        return ok(SUCCESS_CODE,STATUS_SUCCESS,STATUS_SUCCESS,data);
    }

    public static <T> Result<T> ok(Integer code, String status, String msg){
        return ok(code,status,msg,null);
    }

    public static <T> Result<T> ok(Integer code, String msg){
        return ok(code,STATUS_SUCCESS,msg,null);
    }

    public static <T> Result<T> fail(Integer code, String status, String msg, T data){
        return new Result<>(code, status,msg,data);
    }

    public static <T> Result<T> fail(Integer code, String status, String msg){
        return fail(code, status,msg,null);
    }

    public static <T> Result<T> fail(Integer code, String message){
        return fail(code, STATUS_ERROR,message,null);
    }

    public static <T> Result<T> fail(T data){
        return fail(ERROR_CODE, STATUS_ERROR,ERROR_MSG,data);
    }

    public static <T> Result<T> fail(String message){
        return fail(ERROR_CODE, STATUS_ERROR,message,null);
    }

    public static <T> Result<T> fail(){
        return fail(ERROR_CODE, STATUS_ERROR,ERROR_MSG,null);
    }

    public static <T> Result<T> fail(ResultEnumAble resultEnumAble){
        return fail(resultEnumAble.code(), resultEnumAble.status(),resultEnumAble.msg(),null);
    }


}
