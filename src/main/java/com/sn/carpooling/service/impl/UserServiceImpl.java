package com.sn.carpooling.service.impl;

import com.sn.carpooling.dao.UserMapper;
import com.sn.carpooling.entity.User;
import com.sn.carpooling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String getAllUsers() {
        System.out.println(userMapper);
        User user = userMapper.selectByPrimaryKey(1);
        return user.getUsername();
    }
}
