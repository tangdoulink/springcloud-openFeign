package com.zpb.cloud.openfeign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author       pengbo.zhao
 * @description  index
 * @createDate   2022/1/11 10:52
 * @updateDate   2022/1/11 10:52
 * @version      1.0
 */
@RestController
@RequestMapping("index")
public class IndexController {

    @GetMapping("1")
    public String index(){
        return "index -> "+LocalDateTime.now();
    }
}
