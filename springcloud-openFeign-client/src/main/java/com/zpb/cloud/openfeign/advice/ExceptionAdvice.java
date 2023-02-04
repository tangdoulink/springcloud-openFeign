package com.zpb.cloud.openfeign.advice;

import com.zpb.cloud.openfeign.yixian.response.Result;
import com.zpb.cloud.openfeign.yixian.exception.base.BaseUnCheckedException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author       pengbo.zhao
 * @description  异常-通知
 * @createDate   2022/9/20 10:13
 * @updateDate   2022/9/20 10:13
 * @version      1.0
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    private static final String FEIGN_ERROR = "feign 调用异常 case :";

    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandler(Exception e){
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(FeignException.class)
    public Result<String> feignExceptionHandler(FeignException e){
        return Result.fail(Result.ERROR_CODE,FEIGN_ERROR + e.getMessage());
    }

    @ExceptionHandler(BaseUnCheckedException.class)
    public Result<String> baseUnCheckedExceptionHandler(BaseUnCheckedException e){
        return Result.fail(e.getCode(),e.getMessage());
    }

}
