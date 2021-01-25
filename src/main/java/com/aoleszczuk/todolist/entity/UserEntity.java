package com.aoleszczuk.todolist.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Data
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;

    @Pattern(regexp = "[a-zA-Z]{2,30}", message="Please enter a valid name")
    private String name;

    @Pattern(regexp = "[a-zA-Z]{2,30}", message="Please enter a valid surname")
    private String surname;

    @NotBlank(message = "Login is mandatory")
    private String login;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @OneToMany(mappedBy = "user")
    private Collection<ToDoListEntity> tasks;
}
