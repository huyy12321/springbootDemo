package com.springboot.demo.config;

import com.springboot.demo.PO.UserPO;
import com.springboot.demo.service.UserService;
import com.springboot.demo.service.impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    /**
     * 控制权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 控制登录
     * @param at
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {
        AuthenticationInfo info;
       String userName = (String)at.getPrincipal();
       try{
         UserPO userPO =  userService.getUserByName(userName);
        if(userPO != null ){
            info = new SimpleAuthenticationInfo(userName,"123","123");
            return info;
        }
       }catch (Exception e){
           e.printStackTrace();
       }
        return null;
    }
}
