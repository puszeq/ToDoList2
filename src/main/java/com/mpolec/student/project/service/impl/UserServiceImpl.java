package com.mpolec.student.project.service.impl;

import com.mpolec.student.project.entity.UserEntity;
import com.mpolec.student.project.repository.UserRepository;
import com.mpolec.student.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void save(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public UserEntity findByLogin(String login){
        return userRepository.findByLogin(login);
    }
}
