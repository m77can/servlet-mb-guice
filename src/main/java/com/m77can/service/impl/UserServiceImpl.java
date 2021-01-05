package com.m77can.service.impl;

import com.m77can.entity.User;
import com.m77can.mapper.UserMapper;
import com.m77can.service.UserService;
import org.mybatis.guice.transactional.Transactional;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserServiceImpl implements UserService {

    @Inject
    private UserMapper userMapper;

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    @Transactional
    public User findById(String id) {
        return userMapper.findById(id);
    }
}
