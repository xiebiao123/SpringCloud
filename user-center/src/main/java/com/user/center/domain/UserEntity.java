package com.user.center.domain;

import com.user.center.enums.UserStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户DO
 * @author xieb
 * @date 2018/02/23
 */
@Data
public class UserEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String userName;

    private String password;

    private UserStatusEnum status;

    private String regLoginIp;

    private String lastLoginIp;

    private Date createTime;

    private Date updateTime;

    private Integer delStatus;

}
