package com.user.center.server;

import com.user.center.domain.UserCondition;
import com.user.center.domain.UserEntity;

import java.util.List;

public interface UserServer {

    public List<UserEntity> listByCondition(UserCondition condition);

    public UserEntity oneById(Long id);

    public Long insert(UserEntity user);

    public int update(UserEntity user);

    public int delete(Long id);
}
