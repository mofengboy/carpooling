package com.sn.carpooling.service.impl;

import com.sn.carpooling.dao.UserMapper;
import com.sn.carpooling.entity.User;
import com.sn.carpooling.exception.UserNotExistException;
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
    public User getUserInfoByOpenId(String openId) throws UserNotExistException {
        User user = userMapper.selectByOpenId(openId);
        // 用户状态检测
        if (user == null) {
            throw new UserNotExistException(openId);
        }
        User userInfo = new User();
        userInfo.setOpenId(user.getOpenId());
        userInfo.setUsername(user.getUsername());
        userInfo.setEmail(user.getEmail());
        userInfo.setPhoneNumber(user.getPhoneNumber());
        userInfo.setLoginType(user.getLoginType());
        userInfo.setLoginCount(user.getLoginCount());
        userInfo.setLoginIp(user.getLoginIp());

        return null;
    }

    @Override
    public User weChatLogin(String code, String rawData, String signature, String encryptedData, String iv) {
        return null;
    }

    @Override
    public boolean isUserActive(String openId) {
        return false;
    }
}
