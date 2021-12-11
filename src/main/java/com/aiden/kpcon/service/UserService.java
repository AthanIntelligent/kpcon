package com.aiden.kpcon.service;


import com.aiden.kpcon.model.User;

import java.util.List;

public interface UserService {
   User selectOneByOpenId(String openId);

    void insert(User user);

    void update(User user);
}
