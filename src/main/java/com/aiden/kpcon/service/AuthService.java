package com.aiden.kpcon.service;

import com.aiden.kpcon.model.Auth;
import com.aiden.kpcon.model.Role;

import java.util.List;

public interface AuthService {
    List<Auth> selectAuthByUser(List<Role> roleList);
}
