package com.noob.docker_boot.repository;

import com.noob.docker_boot.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
