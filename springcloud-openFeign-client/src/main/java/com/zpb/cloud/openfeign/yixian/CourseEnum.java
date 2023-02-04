package com.zpb.cloud.openfeign.yixian;

import com.zpb.cloud.openfeign.yixian.response.Result;
import com.zpb.cloud.openfeign.yixian.response.ResultEnumAble;
import lombok.AllArgsConstructor;

/**
 * @author       pengbo.zhao
 * @description  排课-枚举
 * @createDate   2022/9/22 10:00
 * @updateDate   2022/9/22 10:00
 * @version      1.0
 */
@AllArgsConstructor
public enum CourseEnum implements ResultEnumAble {

    /**
     * 枚举类
     */
    COURSE_SCHOOL_NOT_EXIST(60000,"排课学校不存在", Result.STATUS_ERROR),
    COURSE_USER_NOT_EXIST(60001,"排课学员不存在",Result.STATUS_ERROR)
    ;


    /**
     * code
     */
    private final Integer code;

    /**
     * msg
     */
    private final String msg;

    /**
     * status
     */
    private final String status;


    @Override
    public Integer code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }

    @Override
    public String status() {
        return status;
    }

}
