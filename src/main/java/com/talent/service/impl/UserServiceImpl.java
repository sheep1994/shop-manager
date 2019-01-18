package com.talent.service.impl;

import com.talent.mapper.FeedbackMapper;
import com.talent.mapper.UserMapper;
import com.talent.model.Feedback;
import com.talent.model.Users;
import com.talent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author guobing
 * @Title: UserServiceImpl
 * @ProjectName shop-manager
 * @Description: TODO
 * @date 2019/1/17下午3:05
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 操作用于信息
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 操作用户反馈表
     */
    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public Users selectByUsername(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addUsers(Users users) {
        userMapper.insertSelective(users);
    }

    @Override
    public int updatePassword(String phone, String newPassword) {
        return userMapper.updatePassword(phone, newPassword);
    }

    @Override
    public int updateUserInfo(Users users) {
        return userMapper.updateByPrimaryKeySelective(users);
    }

    @Override
    public void updateLastLoginTime(Date date, String phone) {
        userMapper.updateLastLoginTime(date, phone);
    }

    @Override
    public List<Users> getAllUser(Integer limit, Integer offset, String sort, String order, String search) {
        return userMapper.getAllUser(limit, offset, sort, order, search);
    }

    @Override
    public int addFeedbackSuggestion(Feedback record) {
        return feedbackMapper.insert(record);
    }

    @Override
    public Integer getUserCount(String search) {
        return userMapper.getUserCount(search);
    }

    @Override
    public Integer setUserAdmin(String phone, Integer campusId) {
        return userMapper.setUserAdmin(phone, campusId);
    }

    @Override
    public Integer setUserCommon(String phone, Integer campusId) {
        return userMapper.setUserCommon(phone,campusId);
    }

    @Override
    public Integer setUserSuperAdmin(String phone, Integer campusId) {
        return userMapper.setUserSuperAdmin(phone,campusId);
    }

    @Override
    public int updateImageUrl(String imageUrl, String phone) {
        return userMapper.updateUserImage(imageUrl, phone);
    }

    @Override
    public String getImageUrl(String phone) {
        return userMapper.getImageUrl(phone);
    }

    @Override
    public List<Users> getDeliverAdmin(Map<String, Object> paramMap) {
        return userMapper.getDeliverAdmin(paramMap);
    }

    @Override
    public int setUserToken(String phoneId, String token) {
        return userMapper.setUserToken(phoneId, token);
    }

    @Override
    public List<Feedback> getFeedbacks(Map<String, Object> paramMap) {
        return feedbackMapper.getFeedbacks(paramMap);
    }

    @Override
    public String getUserToken(String togetherId) {
        return userMapper.getUserToken(togetherId);
    }

    @Override
    public int clearOldToken(String token) {
        return userMapper.clearOldToken(token);
    }

    @Override
    public String getUserPhone(String togetherId) {
        return userMapper.getUserPhone(togetherId);
    }

    @Override
    public List<String> getAllSuperAdminPhone(Map<String, Object> paramterMap) {
        return userMapper.getAllSuperAdminPhone(paramterMap);
    }

    @Override
    public String getUserTokenByPhone(Map<String, Object> paramterMap) {
        return userMapper.getUserTokenByPhone(paramterMap);
    }

    @Override
    public Integer getCountsByDevice(Map<String, Object> paramMap) {
        return userMapper.getCountsByDevice(paramMap);
    }

    @Override
    public List<Users> selectByPhoneAndPassword(Map<String, Object> paramMap) {
        return userMapper.selectByPhoneAndPassword(paramMap);
    }

    @Override
    public Users checkLogin(String phone) {
        return userMapper.checkLogin(phone);
    }

    @Override
    public List<String> getUserByType(Map<String, Object> paramMap) {
        return userMapper.getUserByType(paramMap);
    }
}
