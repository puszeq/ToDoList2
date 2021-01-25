package com.aoleszczuk.todolist.repository;

import com.aoleszczuk.todolist.entity.ToDoListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoListEntity, Integer> {

    List<ToDoListEntity> findAllByOrderByShortDescriptionAsc();

}
