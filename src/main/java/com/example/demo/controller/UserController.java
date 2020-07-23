package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    Logger longger = LogManager.getLogger(this.getClass());

    @RequestMapping("/test")
    public String test(Model model) {

        User user = userService.findByUserNameNote("张三", "张三笔记的的");
        model.addAttribute("username", user.getUserName());
        model.addAttribute("note", user.getNote());
        longger.info("成功查询到了"+user.getNote()+user.getUserName());
        return "index";
    }
}
