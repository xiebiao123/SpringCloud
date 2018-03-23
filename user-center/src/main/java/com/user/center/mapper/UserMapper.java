package com.user.center.mapper;

import com.user.center.domain.UserCondition;
import com.user.center.domain.UserEntity;
import com.user.center.enums.UserStatusEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    List<UserEntity> listByCondition(UserCondition condition);

    UserEntity oneById(Long id);

    int insert(UserEntity user);

    int update(UserEntity user);

    int delete(Long id);
}
