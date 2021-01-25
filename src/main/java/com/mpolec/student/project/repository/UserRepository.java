package com.mpolec.student.project.repository;

import com.mpolec.student.project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByLogin(String login);

}
