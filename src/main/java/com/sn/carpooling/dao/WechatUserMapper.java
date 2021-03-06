package com.sn.carpooling.dao;

import com.sn.carpooling.entity.WechatUser;
import java.util.List;

public interface WechatUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wechat_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wechat_user
     *
     * @mbg.generated
     */
    int insert(WechatUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wechat_user
     *
     * @mbg.generated
     */
    WechatUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wechat_user
     *
     * @mbg.generated
     */
    List<WechatUser> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wechat_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(WechatUser record);
}