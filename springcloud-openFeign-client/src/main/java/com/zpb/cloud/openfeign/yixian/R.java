package com.zpb.cloud.openfeign.yixian;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
        put("status", "Success");
        put("msg", "success");
    }


    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R fail(String msg) {
        return error(-1, msg);
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("status", "error");
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R okObjcectData(Object data) {
        R r = new R();
        r.put("data", data);
        return r;
    }

    public static R okListData(Object data) {
        R r = new R();
        Map result = new HashMap();
        result.put("list", data);
        r.put("data", result);
        return r;
    }
    public static R ok() {
        return new R();
    }

    public static R okData(Object data) {
        R r = new R();
        r.put("data", data);
        return r;
    }

    public static R okReturnValue(Object data) {
        R r = new R();
        r.put("returnValue", data);
        return r;
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
