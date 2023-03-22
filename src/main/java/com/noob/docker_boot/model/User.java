package com.noob.docker_boot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "t_user")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private Integer sex;

    private Integer deleted;

    private Date updateTime;

    private Date createTime;
}
