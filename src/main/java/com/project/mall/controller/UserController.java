package com.project.mall.controller;

import com.project.mall.entity.User;
import com.project.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/user")
    @ResponseBody
    public User showbyid(@RequestParam Integer id){

        return userService.getOneById(id);
    }
}
