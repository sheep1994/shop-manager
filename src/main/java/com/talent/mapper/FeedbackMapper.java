package com.talent.mapper;

import com.talent.model.Feedback;

import java.util.List;
import java.util.Map;

/**
 * @author guobing
 * @Title: FeedbackMapper
 * @ProjectName shop-manager
 * @Description: TODO
 * @date 2019/1/17下午3:07
 */
public interface FeedbackMapper {

    int insert(Feedback record);

    int insertSelective(Feedback record);

    List<Feedback> getFeedbacks(Map<String, Object> paramMap);

}
