package com.zpb.cloud.openfeign.yixian.exception.base;

import com.zpb.cloud.openfeign.yixian.response.ResultAble;

/**
 * @author       pengbo.zhao
 * @description  非检查时-异常,所有的runtime异常基类
 * @createDate   2022/9/22 10:58
 * @updateDate   2022/9/22 10:58
 * @version      1.0
 */

public class BaseUnCheckedException extends RuntimeException{

    private static final long serialVersionUID = -3904726809618553575L;

    /**
     * code/msg 消息体
     */
    private Integer code;

    /**
     * 无参构造
     */
    public BaseUnCheckedException() {
        super();
    }

    /**
     * 有参构造-消息
     * @param message message
     */
    public BaseUnCheckedException(String message) {
        super(message);
    }

    /**
     * 有参构造-异常/消息
     * @param message 出现异常提示信息
     * @param cause   抛出的异常
     */
    public BaseUnCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 有参构造-异常
     * @param cause 抛出的异常
     */
    public BaseUnCheckedException(Throwable cause) {
        super(cause);
    }

    /**
     * 有参构造
     * @param resultAble {@link ResultAble}
     */
    public BaseUnCheckedException(ResultAble resultAble) {
        super(resultAble.msg());
        this.code = resultAble.code();
    }

    public Integer getCode(){
        return code;
    }

}
