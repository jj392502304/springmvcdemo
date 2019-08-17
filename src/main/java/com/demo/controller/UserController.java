package com.demo.controller;


import com.demo.entities.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jieyingjian
 * @since 2019-08-17
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public String login(User user, Model model){
        System.out.println(user);
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token =new UsernamePasswordToken(user.getUserName(),user.getPassword());
        try {
            subject.login(token);
            subject.getSession().setAttribute("currentUser",user);
            return "success";
        }catch (Exception e){
            model.addAttribute("errorInfo","用户名密码错误");
            return "login";
        }
    }

}
