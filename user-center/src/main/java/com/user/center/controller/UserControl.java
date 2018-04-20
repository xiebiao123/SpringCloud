package com.user.center.controller;

import com.user.center.domain.UserCondition;
import com.user.center.domain.UserEntity;
import com.user.center.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControl {

    @Autowired
    private UserServer userServer;

    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/list")
    public List<UserEntity> listByCondition(UserCondition condition) {
        return userServer.listByCondition(condition);
    }

    @GetMapping("/one")
    public UserEntity oneById(@RequestBody Long id) {
        return userServer.oneById(id);
    }

    @PostMapping("/insert")
    public Long insert(@RequestBody UserEntity userEntity) {
        return userServer.insert(userEntity);
    }

    @PostMapping("/update")
    public int update(@RequestBody UserEntity userEntity) {
        return userServer.update(userEntity);
    }

    @GetMapping("/delete")
    public int delete(@RequestBody Long id) {
        return userServer.delete(id);
    }

}
