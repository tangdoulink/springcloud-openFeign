package com.zpb.cloud.openfeign.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author       pengbo.zhao
 * @description  
 * @createDate   2022/1/10 16:26
 * @updateDate   2022/1/10 16:26
 * @version      1.0
 */
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserClientFallback> {

    @Override
    public UserClientFallback create(Throwable cause) {
        return new UserClientFallback();
    }

}
