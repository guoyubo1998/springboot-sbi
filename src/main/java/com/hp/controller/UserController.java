package com.hp.controller;

import com.hp.entity.User;
import com.hp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("word")
    @ResponseBody
    public String sayHello(){
        System.out.println("哈哈哈");
        return "success";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id") Long i){
        User user = userService.queryUserById(i);
        return user;
    }

    @GetMapping("/del/{ids}")
    @ResponseBody
    public String deleteUserById(@PathVariable("ids") Long id){
        userService.deleteUserById(id);
        return "success";
    }

    @GetMapping("list")
    public String queryAll(Model model){
        List<User> userList = userService.queryAll();
        model.addAttribute("users",userList);
        return "item";
    }
}
