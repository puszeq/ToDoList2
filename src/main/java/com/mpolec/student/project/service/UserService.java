package com.mpolec.student.project.service;

import com.mpolec.student.project.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(UserEntity user);

    UserEntity findByLogin(String login);


}
