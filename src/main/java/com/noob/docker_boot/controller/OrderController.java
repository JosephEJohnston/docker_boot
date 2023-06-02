package com.noob.docker_boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class OrderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/order/docker")
    public String helloDocker() {
        return "hello docker" + "\t" + port + "\t" + UUID.randomUUID();
    }

    @GetMapping("/order/index")
    public String index() {
        String serverPort = "服务端口号：" + "\t" + port + "\t" + UUID.randomUUID();

        log.info(serverPort);

        return serverPort;
    }
}
