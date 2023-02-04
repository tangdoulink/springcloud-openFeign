package com.zpb.cloud.openfeign.controller.yixian;

import com.zpb.cloud.openfeign.yixian.exception.base.BaseUnCheckedException;
import com.zpb.cloud.openfeign.yixian.exception.base.CommonExceptionEnum;
import com.zpb.cloud.openfeign.yixian.response.Result;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author       pengbo.zhao
 * @description  service
 * @createDate   2022/9/22 10:33
 * @updateDate   2022/9/22 10:33
 * @version      1.0
 */
@Service
public class ResultService {

    public Result<String> get(){
        return new Random().nextBoolean() ? Result.ok("响应成功") : Result.fail("响应失败");
    }

    public Result<String> get2(){
        if(new Random().nextBoolean()){
            return Result.ok("测试异常响应成功");
        }
        throw new BaseUnCheckedException(CommonExceptionEnum.API_SERVER_ERROR);
    }

}
