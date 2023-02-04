package com.zpb.cloud.openfeign.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author pengbo.zhao
 * @version 1.0
 * @description
 * @createDate 2022/9/28 17:38
 * @updateDate 2022/9/28 17:38
 */

public class ResourcesUtil {

    /**
     * resourceId 开始
     */
    static int resourceId = 1001;

    /**
     * 随机容器
     */
    static List<String> containerIdList = Arrays.asList("C-1","C-2");
    static List<String> containerUnitIdList = Arrays.asList("C-1-1","C-1-2","C-1-3","C-1-4","C-2-1","C-2-2","C-2-3");
    static List<String> timeSliceList = Arrays.asList("13:00","14:00","15:00","16:00","17:00","18:00","19:00");

    /**
     *  ownerId
     */
    static List<String> ownerIdList = Arrays.asList("JL-1","JL-2","JL-3");

    /**
     *
     */
    static List<String> stagesList = Arrays.asList("66","67");


    static Random rand = new Random();

    public static List<String> startEndTimeList(String date, List<String> list){
        ArrayList<String> resultList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(list)){
            LocalTime l1 = LocalTime.parse(list.get(0));
            LocalTime l2 = LocalTime.parse(list.get(1));
            Duration duration = Duration.between(l1, l2);
            // 验证时间区间是否为负,为负表示开始和结束时间不符
            if(!duration.isNegative()){
                int temp = 0;
                while (temp < duration.toHours()){

                    LocalTime nextTime1 = l1.plusHours(temp++);
                    LocalTime nextTime2 = l1.plusHours(temp);
                    if(12 == nextTime1.getHour()){
                        continue;
                    }
                    resultList.add(date + " " + nextTime1 + "-" + nextTime2);
                }
            }
            return resultList;
        }
        return resultList;
    }


    private Object business(List<String> dataList, List<String> timeList){
        ArrayList<List<Resource>> lists = new ArrayList<>();

        if(!CollectionUtils.isEmpty(dataList)) {
            LocalDate l1 = LocalDate.parse(dataList.get(0));
            LocalDate l2 = LocalDate.parse(dataList.get(1));
            Duration duration = Duration.between(l1, l2);
            if(!duration.isNegative()) {
                int temp = 0;

            }
        }
        return null;

    }

    public static List<Resource> dateListAndTimeList(List<String> dateList, List<String> timeList){

        List<Resource> resourceList = new ArrayList<>();

        LocalDate date1 = LocalDate.parse(dateList.get(0));
        LocalDate date2 = LocalDate.parse(dateList.get(1));

        Period period = Period.between(date1, date2);
        // 验证日期不能为负
        if(!period.isNegative()){
            int temp = 0;
            while (temp <= period.getDays()){
                LocalDate localDate = date1.plusDays(temp++);
                resourceList.addAll(startEndTimeList2(localDate.format(DateTimeFormatter.ISO_DATE), timeList));
            }
        }
        return resourceList;
    }

    public static List<Resource> startEndTimeList2(String date, List<String> list){
        ArrayList<Resource> resultList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(list)){
            LocalTime l1 = LocalTime.parse(list.get(0));
            LocalTime l2 = LocalTime.parse(list.get(1));
            Duration duration = Duration.between(l1, l2);
            String prefix = date + " ";
            // 验证时间区间是否为负,为负表示开始和结束时间不符
            if(!duration.isNegative()){
                int temp = 0;
                while (temp < duration.toHours()){
                    LocalTime nextTime1 = l1.plusHours(temp++);
                    LocalTime nextTime2 = l1.plusHours(temp);
                    if(12 == nextTime1.getHour()){
                        continue;
                    }
                    // resultList.add(createResource(prefix + nextTime1, prefix + nextTime2));
                    resultList.addAll(createResources(prefix + nextTime1, prefix + nextTime2));
                }
            }
            return resultList;
        }
        return resultList;
    }

    private static List<Resource> createResources(String nextTime1, String nextTime2){
        List<Resource> resourceList = new ArrayList<>();

        // timeSlice
        TimeSlice timeSlice = new TimeSlice();
        timeSlice.setStartTime(nextTime1);
        timeSlice.setEndTime(nextTime2);

        for(String containerUnitId: containerUnitIdList){
            Resource resource = new Resource();
            resource.setResourceId((resourceId++)+"");

            if(containerUnitId.contains("C-2-")){
                resource.setContainerId(containerIdList.get(1));
                resource.setOwnerId(ownerIdList.get(2));
            } else {
                resource.setContainerId(containerIdList.get(0));
                if(timeSliceList.contains(nextTime1.split(" ")[1])){
                    resource.setOwnerId(ownerIdList.get(1));
                } else {
                    resource.setOwnerId(ownerIdList.get(0));
                }
            }

            resource.setContainerUnitId(containerUnitId);
            resource.setTimeSlice(timeSlice);
            resourceList.add(resource);
        }

        // for(String containerUnitId: containerUnitIdList){
        //         Resource resource = new Resource();
        //         resource.setResourceId((resourceId++)+"");
        //         if(containerUnitId.contains("C-1")){
        //             resource.setContainerId(containerIdList.get(0));
        //         } else {
        //             resource.setContainerId(containerIdList.get(1));
        //             // resource.setOwnerId(ownerIdList.get());
        //         }
        //
        //         resource.setContainerUnitId(containerUnitId);
        //
        //         resource.setTimeSlice(timeSlice);
        //
        //         resourceList.add(resource);
        // }

        return resourceList;
    }
    private static Resource createResource(String nextTime1, String nextTime2){

        // timeSlice
        TimeSlice timeSlice = new TimeSlice();
        timeSlice.setStartTime(nextTime1);
        timeSlice.setEndTime(nextTime2);
        Resource resource = new Resource();
        resource.setResourceId((resourceId++)+"");

        // 随机containerId
        resource.setContainerId(containerIdList.get(rand.nextInt(containerIdList.size())));

        // 随机containerUnitId
        resource.setContainerUnitId(containerUnitIdList.get(rand.nextInt(containerUnitIdList.size())));

        // 随机ownerId
        resource.setOwnerId(ownerIdList.get(rand.nextInt(ownerIdList.size())));

        resource.setTimeSlice(timeSlice);

        return resource;

    }

    /**
     * 随机字符串
     * @param length 随机长度
     * @return String
     */
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<String> timeList = new ArrayList<>(2);
        timeList.add("06:00");
        timeList.add("19:00");

        ArrayList<String> dateList = new ArrayList<>(2);
        dateList.add("2022-09-30");
        // dateList.add("2022-09-30");
        dateList.add("2022-10-09");

        List<Resource> resources = dateListAndTimeList(dateList, timeList);
        System.out.println("resources.size() = " + resources.size());
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resources);
        System.out.println(value);


        // startEndTimeList2(objectMapper, list);
        // 2022-09-30 06:00
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        // LocalDateTime parse = LocalDateTime.parse("2022-09-30 06:00", formatter);
        // System.out.println("parse = " + parse);

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        // LocalTime parse = LocalTime.parse("06:00", formatter);
        // System.out.println("parse = " + parse);

    }

    private static void startEndTimeList2(ObjectMapper objectMapper, ArrayList<String> list) throws JsonProcessingException {
        List<Resource> resources = startEndTimeList2("2022-09-30", list);
        System.out.println("resources.size() = " + resources.size());
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resources);
        System.out.println(value);
    }

    // private void registerOptionsBeanDefinition(BeanDefinitionRegistry registry, String contextId) {
    //     if (isClientRefreshEnabled()) {
    //         // Use "feign.request.options -FeignClient contextId" as the Bean name
    //         String beanName = Request.Options.class.getCanonicalName() + "-" + contextId;
    //         BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder .genericBeanDefinition(OptionsFactoryBean.class);
    //
	//         // set to RefreshScope
    //         definitionBuilder.setScope(" refresh ");
    //         definitionBuilder.addPropertyValue("contextId", contextId);
    //         BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(definitionBuilder.getBeanDefinition(), beanName);
    //
    //         // register for additional proxy Bean
    //         definitionHolder = ScopedProxyUtils.createScopedProxy(definitionHolder, registry, true);
    //
    //         // registered Bean
    //         BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
    //     }
    // }

    private boolean isClientRefreshEnabled() {
        return false;
        // return environment.getProperty("feign.client.refresh-enabled", Boolean.class, false);
    }
}
