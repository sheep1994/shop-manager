package com.talent.mapper;

import com.talent.model.Preferential;

import java.util.List;
import java.util.Map;

/**
 * @author guobing
 * @Title: PreferentialMapper
 * @ProjectName shop-manager
 * @Description: TODO
 * @date 2019/1/18上午10:39
 */
public interface PreferentialMapper {

    int deleteByPrimaryKey(Integer preferentialId);

    int insert(Preferential record);

    int insertSelective(Preferential record);

    Preferential selectByPrimaryKey(Integer preferentialId);

    int updateByPrimaryKeySelective(Preferential record);

    int updateByPrimaryKey(Preferential record);

    List<Preferential> getPreferential(Map<String, Object> paramMap);

}
