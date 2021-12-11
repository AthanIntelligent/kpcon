package com.aiden.kpcon.service.Impl;

import com.aiden.kpcon.mapper.AuthMapper;
import com.aiden.kpcon.mapper.RoleAuthMapper;
import com.aiden.kpcon.model.Auth;
import com.aiden.kpcon.model.Role;
import com.aiden.kpcon.model.RoleAuth;
import com.aiden.kpcon.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    RoleAuthMapper roleAuthMapper;
    @Autowired
    AuthMapper authMapper;
    @Override
    public List<Auth> selectAuthByUser(List<Role> roleList) {
        List<Auth> authList = new ArrayList<>();
        for(Role role:roleList){
            RoleAuth auths = roleAuthMapper.selectByPrimaryKey(role.getRoleId());
            Auth auth = authMapper.selectByPrimaryKey(auths.getRoleId());
            authList.add(auth);
        }
        return null;
    }
}
