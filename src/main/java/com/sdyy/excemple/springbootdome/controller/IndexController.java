package com.sdyy.excemple.springbootdome.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 首页登陆验证设置
 */
@Controller
public class IndexController {
    @PostMapping("/user/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        Map map, HttpSession session){
       if(!StringUtils.isEmpty(username) && "123456".equals(password)){
           session.setAttribute("loginUser",username);
           return  "redirect:/main.html";
       }else{
           map.put("msg","账号密码错误！！");
           return "login";
       }
    }
}
