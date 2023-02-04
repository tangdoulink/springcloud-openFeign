package com.zpb.cloud.openfeign.util;

import feign.Request;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author       pengbo.zhao
 * @description  request-util
 * @createDate   2022/9/21 10:51
 * @updateDate   2022/9/21 10:51
 * @version      1.0
 */

public class RequestUtil {

    public static Request createRequest(String s){
        Request.HttpMethod post = Request.HttpMethod.POST;
        String url = "http://springcloud-openFeign-service/client/order/get";
        HashMap<String, Collection<String>>headers = new HashMap<>(1);
        Request.Body body = Request.Body.create(s.getBytes());
        return Request.create(post,url,headers,body,null);
    }

}
