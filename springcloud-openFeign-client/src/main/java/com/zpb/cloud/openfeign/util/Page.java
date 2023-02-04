package com.zpb.cloud.openfeign.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author       pengbo.zhao
 * @description  
 * @createDate   2022/1/12 10:20
 * @updateDate   2022/1/12 10:20
 * @version      1.0
 */

public class Page<T> extends PageImpl<T> {

    private static final long serialVersionUID = 7673723044285231914L;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Page(@JsonProperty("content") List<T> content,
                @JsonProperty("number") int page,
                @JsonProperty("size") int size,
                @JsonProperty("totalElements") long total) {

        super(content, PageRequest.of(page, size), total);
    }
}
