package com.noob.docker_boot.controller;

import com.noob.docker_boot.model.User;
import com.noob.docker_boot.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("add")
    public void addUser() {
        for (int i = 0; i < 3; i++) {
            User user = new User();

            user.setUsername("test" + i);
            user.setPassword(String.valueOf(UUID
                    .randomUUID()).substring(0, 6));
            user.setSex(new Random().nextInt(2));

            userService.addUser(user);
        }
    }

    @GetMapping("find/{id}")
    public User findUserById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }
}
