package com.m77can.service;

import com.m77can.entity.User;

public interface UserService {
    User create(User user);

    User findById(String id);
}
