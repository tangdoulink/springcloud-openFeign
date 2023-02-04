package com.zpb.cloud.openfeign.feign;

import feign.Request;
import feign.Response;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author       pengbo.zhao
 * @description  自定义-打印日志
 * @createDate   2022/1/14 17:16
 * @updateDate   2022/1/14 17:16
 * @version      1.0
 */

public class CustomLog extends feign.Logger {

    private final org.slf4j.Logger logger;

    public CustomLog() {
        this(feign.Logger.class);
    }

    public CustomLog(Class<?> clazz){
        this(LoggerFactory.getLogger(clazz));
    }

    public CustomLog(org.slf4j.Logger logger){
        this.logger = logger;
    }

    @Override
    protected void log(String configKey, String format, Object... args) {
        if (logger.isInfoEnabled()) {
            logger.info(String.format(methodTag(configKey) + format, args));
        }
    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        if (logger.isInfoEnabled()) {
            super.logRequest(configKey, logLevel, request);
        }
    }

    @Override
    protected void logRetry(String configKey, Level logLevel) {
        super.logRetry(configKey, logLevel);
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
        return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
    }

    @Override
    protected IOException logIOException(String configKey, Level logLevel, IOException ioe, long elapsedTime) {
        return super.logIOException(configKey, logLevel, ioe, elapsedTime);
    }

}
