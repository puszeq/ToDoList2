package com.aoleszczuk.todolist.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ToDoListModel {

    private int id;

    @NotBlank(message = "You have to provide short description!")
    private String shortDescription;

    private String detailedDescription;

}
