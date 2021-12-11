package com.aiden.kpcon.mapper;

import com.aiden.kpcon.model.UserRole;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);


//    List<UserRole> selectRoleByUserId(Integer userId);
}