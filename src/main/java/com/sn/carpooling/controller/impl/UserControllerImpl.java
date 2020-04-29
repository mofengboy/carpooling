package com.sn.carpooling.controller.impl;

import com.sn.carpooling.controller.UserController;
import com.sn.carpooling.service.UserService;
import com.sn.carpooling.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;

    @Override
    @RequestMapping(value = "/info")
    public String getUserInfo() {
        String info = userService.getAllUsers();
        return info;
    }
}
