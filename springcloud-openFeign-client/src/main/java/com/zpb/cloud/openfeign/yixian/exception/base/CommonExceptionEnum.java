package com.zpb.cloud.openfeign.yixian.exception.base;

import com.zpb.cloud.openfeign.yixian.response.ResultAble;
import lombok.AllArgsConstructor;

/**
 * @author       pengbo.zhao
 * @description  响应异常
 * @createDate   2022/9/22 11:20
 * @updateDate   2022/9/22 11:20
 * @version      1.0
 */
@AllArgsConstructor
public enum CommonExceptionEnum implements ResultAble {

    /**
     * 默认异常
     */
    DEFAULT_SERVER_ERROR(500, "服务不可用"),
    API_SERVER_ERROR(601, "接口调用异常"),

    ;

    /**
     * code
     */
    private final Integer code;

    /**
     * msg
     */
    private final String msg;


    @Override
    public Integer code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }

}
