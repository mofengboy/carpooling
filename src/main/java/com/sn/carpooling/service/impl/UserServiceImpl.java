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
    public String getAllUserCounts() {
        return null;
    }

    @Override
    public String getUserInfoByOpenId(String openId) {
        return null;
    }

    @Override
    public String weChatLogin(String code, String rawData, String signature, String encryptedData, String iv) {
        return null;
    }
}
