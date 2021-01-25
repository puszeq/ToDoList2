package com.aoleszczuk.todolist.service.impl;

import com.aoleszczuk.todolist.entity.UserEntity;
import com.aoleszczuk.todolist.repository.UserRepository;
import com.aoleszczuk.todolist.service.UserService;
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
