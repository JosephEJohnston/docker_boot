package com.noob.docker_boot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class UserDTO implements Serializable {

    private Long id;

    private String username;

    private String password;

    private Integer sex;

    private Integer deleted;

    private Date updateTime;

    private Date createTime;
}
