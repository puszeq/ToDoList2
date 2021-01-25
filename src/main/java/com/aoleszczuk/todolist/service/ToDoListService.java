package com.aoleszczuk.todolist.service;

import com.aoleszczuk.todolist.entity.ToDoListEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToDoListService {

    List<ToDoListEntity> findAll();

    ToDoListEntity findById(int id);

    void save(ToDoListEntity student);

    void deleteById(int id);
}
