package com.mpolec.student.project.service.impl;

import com.mpolec.student.project.entity.ToDoListEntity;
import com.mpolec.student.project.repository.ToDoListRepository;
import com.mpolec.student.project.service.ToDoListService;
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
