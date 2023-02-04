package com.zpb.cloud.openfeign.controller.yixian;

import com.zpb.cloud.openfeign.yixian.CourseEnum;
import com.zpb.cloud.openfeign.yixian.response.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author       pengbo.zhao
 * @description  result-controller
 * @createDate   2022/9/22 10:30
 * @updateDate   2022/9/22 10:30
 * @version      1.0
 */
@RestController
@RequestMapping("course/v1/")
public class ResultController {

    @Resource
    private ResultService resultService;

    @GetMapping("get/1")
    public Result<String> get(){
        //TODO 查询DB或RPC调用
        Result<String> result = resultService.get();
        // 类型方式返回
        return Result.SUCCESS_CODE == result.getCode() ? result : Result.fail("查询失败");

    }

    @GetMapping("get/2")
    public Result<String> get2(){
        //TODO 查询DB或RPC调用
        Result<String> result = resultService.get();
        // 枚举方式返回
        return Result.SUCCESS_CODE == result.getCode() ? result : Result.fail(CourseEnum.COURSE_SCHOOL_NOT_EXIST);
    }

    @GetMapping("get/3")
    public Result<String> get3(){
        //TODO 查询DB或RPC调用
        Result<String> result = resultService.get2();
        // 枚举方式返回
        return Result.SUCCESS_CODE == result.getCode() ? result : Result.fail(CourseEnum.COURSE_SCHOOL_NOT_EXIST);
    }
}
