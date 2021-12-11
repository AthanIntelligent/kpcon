package com.aiden.kpcon.service.Impl;

import com.aiden.kpcon.mapper.RoleMapper;
import com.aiden.kpcon.mapper.UserRoleMapper;
import com.aiden.kpcon.model.Role;
import com.aiden.kpcon.model.UserRole;
import com.aiden.kpcon.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

}
