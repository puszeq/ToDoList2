package com.mpolec.student.project.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class ToDoListModel {

    private int id;

    @NotBlank(message = "You have to provide short description!")
    private String shortDescription;

    private String detailedDescription;

}
