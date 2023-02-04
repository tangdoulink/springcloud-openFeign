package com.zpb.cloud.openfeign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author       pengbo.zhao
 * @description  用户
 * @createDate   2022/1/6 15:35
 * @updateDate   2022/1/6 15:35
 * @version      1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Long id;

    private String name;

    private Integer age;

}
