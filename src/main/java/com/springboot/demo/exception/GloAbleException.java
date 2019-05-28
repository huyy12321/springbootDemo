package com.springboot.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 * ControllerAdvice 表示扫描所有的controller
 * ExceptionHandler 表示接收的异常类型
 */
@ControllerAdvice
public class GloAbleException {
    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public Map<String,Object> runtimeException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","1");
        map.put("message","出现异常");
        e.printStackTrace();
        return map;
    }
}
