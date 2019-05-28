package com.springboot.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Component注解适用于中立的类，不清楚属于哪层的时候哦用这个注解
 * 分布式情况下定时任务的重复消费
 * XXLJOB一个分布式调度平台
 */
@Component
public class TimerTest {
    /**
     * Scheduled表示这是定时任务 fixedRate表示多少毫秒执行一次
     */
    @Scheduled(fixedRate = 5000)
    public void showTime(){
        System.out.println("当前时间戳："+System.currentTimeMillis());
    }
}
