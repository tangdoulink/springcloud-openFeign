package com.zpb.cloud.openfeign.exception;

import feign.FeignException;
import feign.Request;

/**
 * @author       pengbo.zhao
 * @description  自定义-feign-异常
 * @createDate   2022/9/20 10:33
 * @updateDate   2022/9/20 10:33
 * @version      1.0
 */

public class OpenFeignClientException extends FeignException {

    private static final long serialVersionUID = -2157592889602864126L;

    public OpenFeignClientException(int status, String message, Throwable cause) {
        super(status, message, cause);
    }

    public OpenFeignClientException(int status, String message, Throwable cause, byte[] responseBody) {
        super(status, message, cause, responseBody);
    }

    public OpenFeignClientException(int status, String message) {
        super(status, message);
    }

    public OpenFeignClientException(int status, String message, byte[] responseBody) {
        super(status, message, responseBody);
    }

    public OpenFeignClientException(int status, String message, Request request, Throwable cause) {
        super(status, message, request, cause);
    }

    public OpenFeignClientException(int status, String message, Request request, Throwable cause, byte[] responseBody) {
        super(status, message, request, cause, responseBody);
    }

    public OpenFeignClientException(int status, String message, Request request) {
        super(status, message, request);
    }

    public OpenFeignClientException(int status, String message, Request request, byte[] responseBody) {
        super(status, message, request, responseBody);
    }

}
