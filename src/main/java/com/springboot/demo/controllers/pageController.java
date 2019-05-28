package com.springboot.demo.controllers;

import com.springboot.demo.service.AsyncTest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class pageController {
    /**
     * 使用Controller注解，返回的字符串会去templates文件夹找有没有这个html页面
     * @param model 向前端传值用
     * @return
     */
    @Autowired
    private AsyncTest asyncTest;

    /**
     * 读取配置文件自定义参数
     */
    @Value("${name}")
    private String name;


    @RequestMapping("/toIndex")
    public String toIndex(Model model){
        Map<String,Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("1111");
        list.add("2222");
        list.add("3333");

        map.put("name","hyy");
        map.put("list",list);
        map.put("mobile","1234213");
       model.addAllAttributes(map);
        return "index";
    }

    @RequestMapping("/loginPage")
    public String loginPage(){
       /* System.out.println("Main thread id :"+Thread.currentThread().getId());
        asyncTest.asyncOut();*/
       System.out.println(name);
        return "login";
    }

    @RequestMapping("/loginAction")
    @ResponseBody
    public String loginAction(String userName,String password){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(userName,password);
        try{
            subject.login(token);
            return "登录成功";

        } catch (Exception e){
            e.printStackTrace();
            return "登录失败";
        }
    }
}
