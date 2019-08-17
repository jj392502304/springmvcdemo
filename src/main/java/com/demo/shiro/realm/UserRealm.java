package com.demo.shiro.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.entities.User;
import com.demo.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    //权限验证
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //身份验证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        QueryWrapper<User> qm = new QueryWrapper<User>().eq("username", token.getPrincipal());
        User user = userService.getOne(qm);
        try {
            if(user!=null){
                AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), "");
                return authenticationInfo;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
