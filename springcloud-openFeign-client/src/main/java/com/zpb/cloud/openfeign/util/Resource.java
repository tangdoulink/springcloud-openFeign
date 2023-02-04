package com.zpb.cloud.openfeign.util;

import lombok.Data;

/**
 * @author pengbo.zhao
 * @version 1.0
 * @description
 * @createDate 2022/9/28 17:46
 * @updateDate 2022/9/28 17:46
 */
@Data
public class Resource {

    private String resourceId;
    private String containerId;
    private String containerUnitId;
    private String ownerId;
    private TimeSlice timeSlice;
    private UsedInfo usedInfo;

}
