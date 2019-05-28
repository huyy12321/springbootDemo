package com.springboot.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTest {
    @Async
    public void asyncOut(){
        System.out.println("async thread id :"+Thread.currentThread().getId());
    }
}
