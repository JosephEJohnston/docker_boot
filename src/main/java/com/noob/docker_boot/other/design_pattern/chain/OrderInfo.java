package com.noob.docker_boot.other.design_pattern.chain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class OrderInfo {
    private String productId;
    private String userId;
    private BigDecimal amount;
}
