package com.noob.docker_boot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RankingUserDTO {
    private Long id;

    private Double source;

    private String name;
}
