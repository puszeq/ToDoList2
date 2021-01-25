package com.aoleszczuk.todolist.service;

import com.aoleszczuk.todolist.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(UserEntity user);

    UserEntity findByLogin(String login);


}
