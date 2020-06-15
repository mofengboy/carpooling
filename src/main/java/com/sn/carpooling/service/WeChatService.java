package com.sn.carpooling.service;

import com.sn.carpooling.common.GenericResponse;

/**
 * 微信业务接口
 */
public interface WeChatService {

    /**
     * 小程序登录
     * @param code
     * @return
     */
    String wxLogin(String code)throws Exception;

}
