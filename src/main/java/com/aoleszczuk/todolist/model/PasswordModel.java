package com.aoleszczuk.todolist.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PasswordModel {

    @NotBlank(message = "Can't be empty!")
    String oldPassword;

    @NotBlank(message = "Can't be empty!")
    String newPassword;

    @NotBlank(message = "Can't be empty!")
    String repeatedPassword;

}
