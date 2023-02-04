package com.zpb.cloud.openfeign.yixian.response;

/**
 * @author       pengbo.zhao
 * @description  响应-枚举-公用接口
 * @createDate   2022/9/22 09:45
 * @updateDate   2022/9/22 09:45
 * @version      1.0
 */
public interface ResultAble {

    /**
     * code码
     * @return Integer
     */
    Integer code();

    /**
     * msg
     * @return String
     */
    String msg();

}
