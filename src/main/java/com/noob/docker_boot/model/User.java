package com.noob.docker_boot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "t_user")
@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Integer id;

    private String username = "";

    private String password = "";

    private Integer sex = 0;

    private Integer deleted = 0;

    @Column(insertable = false, updatable = false)
    private Date updateTime;

    @Column(insertable = false)
    private Date createTime;
}
