package com.project.mall.controller;

import com.project.mall.entity.Good;
import com.project.mall.entity.User;
import com.project.mall.service.GoodService;
import com.project.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    GoodService goodService;
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public String index(Model model, Authentication authentication, HttpServletRequest httpServletRequest){
     /*   if(authentication!=null){
            String username=authentication.getName();
            User user=userService.fingByName(username);
            *//*model.addAttribute("user",user);*//*
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("user",user);
        }*/

        List<Good> goods=goodService.fingAll();
        model.addAttribute("goods",goods);

        return "/index";
    }
    @RequestMapping("/index")
    public String toindex(){
        return "redirect:/";
    }
    @GetMapping("/mylogin")
    public String mylogin(){
        return "/mylogin";
    }
    @ResponseBody
    @RequestMapping("/order")
    public String order(){
        return "未拦截";
    }
}
