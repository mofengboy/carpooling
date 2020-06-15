package com.sn.carpooling.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sn.carpooling.common.GenericResponse;
import com.sn.carpooling.common.ServiceError;
import com.sn.carpooling.entity.User;
import com.sn.carpooling.entity.WechatUser;
import com.sn.carpooling.service.WeChatService;
import com.sn.carpooling.util.Jcode2SessionUtil;
import com.sn.carpooling.util.JwtTokenUtil;
import com.sn.carpooling.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 微信业务实现类
 */
@Service
@Slf4j
public class WeChatServiceImpl implements WeChatService {

    //@Value("${weChat.appid}")
    private String appid = "sdsdf";

    //@Value("${weChat.secret}")
    private String secret ="sdfdf";

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private User user;

    @Autowired
    private WechatUser wechatUser;

    @Override
    public String wxLogin(String code) throws Exception{
        JSONObject sessionInfo = JSONObject.parseObject(jcode2Session(code));

        Assert.notNull(sessionInfo,"code 无效");

        Assert.isTrue(0 == sessionInfo.getInteger("errcode"),sessionInfo.getString("errmsg"));

        // 获取用户唯一标识符 openid成功
        // 模拟从数据库获取用户信息

//        user.setId(1L);
        Set authoritiesSet = new HashSet();
        // 模拟从数据库中获取用户权限
        authoritiesSet.add(new SimpleGrantedAuthority("member"));
        user.setAuthorities(authoritiesSet);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("id",user.getId().toString());
        hashMap.put("authorities",authoritiesSet);
        String token = JwtTokenUtil.generateToken(user);
        redisUtil.hset(token,hashMap);

        return token;
    }

    /**
     * 登录凭证校验
     * @param code
     * @return
     * @throws Exception
     */
    private String jcode2Session(String code)throws Exception{
        String sessionInfo = Jcode2SessionUtil.jscode2session(appid,secret,code,"authorization_code");//登录grantType固定
        log.info(sessionInfo);
        return sessionInfo;
    }
}
