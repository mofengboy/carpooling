package com.sn.carpooling.controller.impl;

import com.sn.carpooling.common.GenericResponse;
import com.sn.carpooling.common.ServiceError;
import com.sn.carpooling.controller.UserController;
import com.sn.carpooling.service.UserService;
import com.sn.carpooling.service.WeChatService;
import com.sn.carpooling.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private WeChatService weChatService;

    /**
     * code登录获取用户openid
     * @param code
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/weChatLogin")
    public GenericResponse login(String code){
        try {
            return GenericResponse.response(ServiceError.NORMAL,weChatService.wxLogin(code));
        } catch (Exception e) {
            System.out.println(e);
            return GenericResponse.response(false,-1,e.getMessage(),null);
        }
    }

    @Override
    @RequestMapping(value = "/info")
    public String getUserInfo() {
        return null;
    }
}
