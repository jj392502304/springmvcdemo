package com.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.entities.User;
import com.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jieyingjian
 * @since 2019-07-31
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    @RequestMapping("/find")
    public Object find(){
        userService.list(new QueryWrapper<User>().eq("age",18));
        return userService.list();
    }
    @RequestMapping("/ex")
    public Object ex(){
        throw new RuntimeException(new NullPointerException());
    }
}
