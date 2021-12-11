package com.aiden.kpcon.mapper;

import com.aiden.kpcon.model.RoleAuth;

public interface RoleAuthMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(RoleAuth record);

    int insertSelective(RoleAuth record);

    RoleAuth selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(RoleAuth record);

    int updateByPrimaryKey(RoleAuth record);

}