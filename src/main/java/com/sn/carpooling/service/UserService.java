package com.sn.carpooling.service;

import com.sn.carpooling.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 获取所有用户数量
     *
     * @return String
     */
    String getAllUserCounts();

    /**
     * 获取用户基本信息通过openId
     *
     * @param openId 用户开放Id(自定义）
     * @return
     */
    String getUserInfoByOpenId(String openId);

    /**
     * 微信小程序登录
     *
     * @param code          code
     * @param rawData       rawData
     * @param signature     签名
     * @param encryptedData encryptedData
     * @param iv            iv
     * @return
     */
    String weChatLogin(String code, String rawData, String signature, String encryptedData, String iv);

}
