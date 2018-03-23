package com.user.center.server.impl;

import com.user.center.domain.UserCondition;
import com.user.center.domain.UserEntity;
import com.user.center.mapper.UserMapper;
import com.user.center.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServerImpl implements UserServer{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> listByCondition(UserCondition condition) {
        return userMapper.listByCondition(condition);
    }

    @Override
    public UserEntity oneById(Long id) {
        return userMapper.oneById(id);
    }

    @Override
    public Long insert(UserEntity user) {
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public int update(UserEntity user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(Long id) {
        return userMapper.delete(id);
    }
}
