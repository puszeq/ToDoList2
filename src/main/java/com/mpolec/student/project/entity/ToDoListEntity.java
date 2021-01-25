package com.mpolec.student.project.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task")
public class ToDoListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "shortDesc")
    private String shortDescription;

    @Column(name = "detailedDesc")
    private String detailedDescription;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "userid")
    private UserEntity user;
}
