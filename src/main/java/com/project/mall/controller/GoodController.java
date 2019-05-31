package com.project.mall.controller;

import com.project.mall.entity.Good;
import com.project.mall.entity.User;
import com.project.mall.service.GoodService;
import com.project.mall.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodController {
    @Autowired
    GoodService goodService;


    @PostMapping("/good/upload")
    public String goodUpload(@RequestParam MultipartFile file, HttpServletRequest httpServletRequest){
        String path="F:\\java\\javaWorkplace\\project\\mall\\src\\main\\resources\\static\\img\\";
        String goodpicture=FileUtils.upload(file,path);
        String goodname = httpServletRequest.getParameter("goodname");
        Double originprice=Double.parseDouble(httpServletRequest.getParameter("originprice"));
        Good good=new Good(goodname,goodpicture,originprice);
        goodService.insertGood(good);

        return "redirect:/good/toupload";
    }
    @RequestMapping("/test/good")
    @ResponseBody
    public Good testGood(@RequestParam int id){
        return goodService.getGoodById(id);
    }
    @RequestMapping("/good/toupload")
    public String toupload(){
        return "/uploadgood";
    }
    @RequestMapping("/showgood")
    public String showGood(Model model){
       List<Good> goods = goodService.fingAll();

        model.addAttribute("goods",goods);
        return "/showgood";
    }
    @RequestMapping("/item/{id}")
    public String showSingleGood(@PathVariable int id,Model model){
        Good good = goodService.getGoodById(id);
        model.addAttribute("item",good);
        System.out.println(good.getGoodpicture());
        return "/item";

    }
    @RequestMapping("/good/showcart")
    public String showCart(Model model,HttpSession httpSession){
        User user= (User) httpSession.getAttribute("user");
        int id=user.getUserid();
        List<Good> cart = goodService.findByUserId(id);
        model.addAttribute("cart",cart);
        return "/cart";
    }
}
