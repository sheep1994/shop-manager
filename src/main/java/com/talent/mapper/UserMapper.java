package com.talent.mapper;

import com.talent.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author guobing
 * @Title: UserMapper
 * @ProjectName shop-manager
 * @Description: TODO
 * @date 2019/1/16下午6:09
 */
public interface UserMapper {
    /**
     * 根据主键删除
     * @param phone
     * @return
     */
    int deleteByPrimaryKey(String phone);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(Users record);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insertSelective(Users record);

    /**
     * 根据主键查询数据
     * @param phone
     * @return
     */
    Users selectByPrimaryKey(String phone);

    /**
     * 根据主键修改数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Users record);

    /**
     * 根据主键修改数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(Users record);


    /**
     * 修改密码
     * @param phone
     * @param newPassword
     * @return
     */
    int updatePassword(@Param(value="phone")String phone, @Param(value="newPassword")String newPassword);

    /**
     * 修改最后一次登录的时间
     * @param date
     * @param phone
     */
    void updateLastLoginTime(@Param(value="date") Date date, @Param(value="phone")String phone);

    /**
     * 获取所有用户，分页
     * @param limit
     * @param offset
     * @param sort
     * @param order
     * @param search
     * @return
     */
    List<Users> getAllUser(@Param(value="limit")Integer limit, @Param(value="offset")Integer offset, @Param(value="sort")String sort, @Param(value="order")String order, @Param(value="search")String search);

    /**
     * 根据搜索条件获取用户数量
     * @param search
     * @return
     */
    Integer getUserCount(@Param(value="search")String search);

    /**
     * 设置为管理员
     * @param phone
     * @param campusId
     * @return
     */
    Integer setUserAdmin(@Param(value="phone")String phone, @Param(value="campusId")Integer campusId);

    /**
     * 设置为普通管理员
     * @param phone
     * @param campusId
     * @return
     */
    Integer setUserCommon(@Param(value="phone")String phone,@Param(value="campusId")Integer campusId);

    /**
     * 设置为超级管理员
     * @param phone
     * @param campusId
     * @return
     */
    Integer setUserSuperAdmin(@Param(value="phone")String phone, @Param(value="campusId")Integer campusId);

    /**
     * 更新用户头像
     * @param imageUrl
     * @param phone
     * @return
     */
    int updateUserImage(@Param(value="imageUrl")String imageUrl, @Param(value="phone")String phone);

    /**
     * 获取用户头像
     * @param phone
     * @return
     */
    String getImageUrl(@Param(value="phone")String phone);

    /**
     * 获取失效的用户
     * @param paramMap
     * @return
     */
    List<Users> getDeliverAdmin(Map<String, Object> paramMap);

    /**
     * 设置用户token
     * @param phoneId
     * @param token
     * @return
     */
    int setUserToken(@Param(value="phone")String phoneId, @Param(value="token")String token);

    /**
     * 获取用户token
     * @param togetherId
     * @return
     */
    String getUserToken(@Param(value="togetherId")String togetherId);

    /**
     * 清除历史token
     * @param token
     * @return
     */
    int clearOldToken(@Param(value="token")String token);

    /**
     * 获取用户主键
     * @param togetherId
     * @return
     */
    String getUserPhone(@Param(value="togetherId")String togetherId);

    /**
     * 获取所有超级管理员主键
     * @param paramterMap
     * @return
     */
    List<String> getAllSuperAdminPhone(Map<String, Object> paramterMap);

    /**
     * 获取用户token
     * @param paramterMap
     * @return
     */
    String getUserTokenByPhone(Map<String, Object> paramterMap);

    /**
     * 获取不同设备用户的个数
     * @param paramMap
     * @return
     */
    Integer getCountsByDevice(Map<String, Object> paramMap);

    /**
     * 根据主键和密码查询用户
     * @param paramMap
     * @return
     */
    List<Users> selectByPhoneAndPassword(Map<String, Object> paramMap);

    /**
     * 验证登录
     * @param phone
     * @return
     */
    Users checkLogin(String phone);

    /**
     * 根据类型获取用户
     * @param paramMap
     * @return
     */
    List<String> getUserByType(Map<String, Object> paramMap);
}
