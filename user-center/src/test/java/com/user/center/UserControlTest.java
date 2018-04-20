package com.user.center;

import com.user.center.controller.UserControl;
import com.user.center.domain.UserCondition;
import com.user.center.domain.UserEntity;
import com.user.center.enums.UserStatusEnum;
import com.user.center.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControlTest {

    private MockMvc mockMvc;

    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new UserControl()).build();
    }

    @Test
    public void testHello() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(mvcResult -> {
                    System.out.println(mvcResult.getResponse().getStatus());
                    System.out.println(mvcResult.getResponse().getContentAsString());
                });
    }

    @Test
    public void testInsert() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("aa");
        userEntity.setPassword("a123456");
        userEntity.setStatus(UserStatusEnum.NORMAL);
        userEntity.setLastLoginIp("172.1.1.1");
        userEntity.setCreateTime(new Date());
        userMapper.insert(userEntity);
        userEntity.setUserName("bb");
        userEntity.setPassword("b123456");
        userEntity.setStatus(UserStatusEnum.DELETE);
        userMapper.insert(userEntity);
        userEntity.setUserName("cc");
        userEntity.setPassword("b123456");
        userEntity.setStatus(UserStatusEnum.NORMAL);
        userMapper.insert(userEntity);
        UserCondition condition = new UserCondition();
        Assert.assertEquals(3,userMapper.listByCondition(condition).size());
    }

    @Test
    public void testQuery() throws Exception {
        UserCondition condition = new UserCondition();
        List<UserEntity> users = userMapper.listByCondition(condition);
        System.out.println(users.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        UserEntity user = userMapper.oneById(3L);
        System.out.println(user.toString());
        user.setUserName("neo");
        userMapper.update(user);
        Assert.assertTrue(("neo".equals(userMapper.oneById(3L).getUserName())));
    }
}
