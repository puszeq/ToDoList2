package com.aoleszczuk.todolist.service.impl;

import com.aoleszczuk.todolist.entity.ToDoListEntity;
import com.aoleszczuk.todolist.repository.ToDoListRepository;
import com.aoleszczuk.todolist.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListServiceImpl implements ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Override
    public List<ToDoListEntity> findAll() {
        return toDoListRepository.findAllByOrderByShortDescriptionAsc();
    }

    @Override
    public ToDoListEntity findById(int id) {
        Optional<ToDoListEntity> result = toDoListRepository.findById(id);

        ToDoListEntity task;

        if(result.isPresent()){
            task = result.get();
        }
        else {
            throw new RuntimeException("Whoops, can't find task ID: " + id);
        }

        return task;
    }

    @Override
    public void save(ToDoListEntity task) {
        toDoListRepository.save(task);
    }

    @Override
    public void deleteById(int id) {
        toDoListRepository.deleteById(id);
    }
}
