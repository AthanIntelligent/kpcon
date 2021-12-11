package com.aiden.kpcon.service.Impl;

import com.aiden.kpcon.mapper.UserMapper;
import com.aiden.kpcon.model.User;
import com.aiden.kpcon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectOneByOpenId(String openId) {
        return userMapper.selectByOpenId(openId);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
