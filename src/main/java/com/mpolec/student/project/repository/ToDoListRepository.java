package com.mpolec.student.project.repository;

import com.mpolec.student.project.entity.ToDoListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoListEntity, Integer> {

    List<ToDoListEntity> findAllByOrderByShortDescriptionAsc();

}
