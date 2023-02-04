package com.zpb.cloud.openfeign.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author       pengbo.zhao
 * @description  返回结果
 * @createDate   2021/1/19 10:21 下午
 * @updateDate   2021/1/19 10:21 下午
 * @version      1.0
 **/
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    /**
     * 序列化标识
     */
    private static final long serialVersionUID = -893450653690451897L;

    /**
     * 成功码
     */
    public static final String SUCCESS_CODE = "200";

    /**
     * 成功信息
     */
    public static final String SUCCESS_MESSAGE = "成功";

    /**
     * 失败码
     */
    public static final String FAIL_CODE = "500";

    /**
     * 失败信息
     */
    public static final String FAIL_MESSAGE = "失败";

    /**
     * 参数为空码
     */
    public static final String PARAMS_FAIL_CODE = "400";

    /**
     * 参数为空码信息
     */
    public static final String PARAMS_FAIL_CODE_MSG = "参数错误";
    
    /**
     * 状态码
     */
    public String code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回结果
     */
    private T data;


    public Result<T> code(String code){
        this.setCode(code);
        return this;
    }

    public Result<T> message(String msg){
        this.setMsg(msg);
        return this;
    }

    public Result<T> data(T data){
        this.setData(data);
        return this;
    }

    public Result(String code, String msg) {
        this(code,msg,null);
    }

    public Result(String code, String msg, T data) {
        super();
        this.code(code).message(msg).data(data);
    }

    public static <T> Result<T> succ(String code, String msg, T data){
        return new Result<>(code,msg,data);
    }
    
    public static <T> Result<T> succ(T data){
        return new Result<>(SUCCESS_CODE,SUCCESS_MESSAGE,data);
    }

    public static <T> Result<T> succ(String code, String msg){
        return new Result<>(code,msg,null);
    }

    public static <T> Result<T> fail(String code, String msg, T data){
        return new Result<>(code,msg,data);
    }

    public static <T> Result<T> fail(T data){
        return new Result<>(FAIL_CODE,FAIL_MESSAGE,data);
    }

    public static <T> Result<T> fail(String code, String msg){
        return new Result<>(code,msg,null);
    }
    public static <T> Result<T> fail(String msg){
        return new Result<>(FAIL_CODE,msg,null);
    }

    public static <T> Result<T> fail(){
        return new Result<>(FAIL_CODE,FAIL_MESSAGE,null);
    }

}
