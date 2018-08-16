package com.loylin.springbootdemo.controller;

import com.loylin.springbootdemo.entity.User;
import com.loylin.springbootdemo.service.UserService;
import com.loylin.springbootdemo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("login")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(value = {"", "/"})
    public Response login(String account, String password){
        Response response = new Response();
        if (account == null || account.length() == 0
                || password == null || password.length() == 0){
            response.setState(false);
            response.setMessage("账号或密码为空!");
            return response;
        }

        User user =  userService.queryLogin(account, password);
        response.setState(true);
        response.setMessage("登陆成功!");
        response.setData(user);
        return response;
    }
}
