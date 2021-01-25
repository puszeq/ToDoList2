package com.mpolec.student.project.service;

import com.mpolec.student.project.entity.ToDoListEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToDoListService {

    List<ToDoListEntity> findAll();

    ToDoListEntity findById(int id);

    void save(ToDoListEntity student);

    void deleteById(int id);
}
