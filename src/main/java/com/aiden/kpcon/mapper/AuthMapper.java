package com.aiden.kpcon.mapper;

import com.aiden.kpcon.model.Auth;

public interface AuthMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(Auth record);

    int insertSelective(Auth record);

    Auth selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(Auth record);

    int updateByPrimaryKey(Auth record);
}