package com.wbz.controller;


import com.wbz.model.User;
import com.wbz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add")
    public int addUser(User user){
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all")
    public Object findAllUsers(
            @RequestParam(name = "pageNum",required = false,defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize",required = false,defaultValue = "20")
            int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }


}
