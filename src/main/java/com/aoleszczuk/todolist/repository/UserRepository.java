package com.aoleszczuk.todolist.repository;

import com.aoleszczuk.todolist.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByLogin(String login);

}
