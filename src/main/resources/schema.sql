-- db2021
CREATE TABLE `t_user` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '用户名',
    `password` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '密码',
    `sex` TINYINT NOT NULL DEFAULT '0' COMMENT '性别 0=女 1=男',
    `deleted` TINYINT NOT NULL DEFAULT '0' COMMENT '删除标志，默认 0 不删除，1 删除',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB AUTO_INCREMENT=1114 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

