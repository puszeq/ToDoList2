package com.aoleszczuk.todolist.controller;

import com.aoleszczuk.todolist.entity.ToDoListEntity;
import com.aoleszczuk.todolist.entity.UserEntity;
import com.aoleszczuk.todolist.model.ToDoListModel;
import com.aoleszczuk.todolist.service.ToDoListService;
import com.aoleszczuk.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/tasks")
public class ToDoListController {

    @Autowired
    private UserService userService;

    @Autowired
    private ToDoListService toDoListService;


    @GetMapping("/list")
    public String listTasks(Model model, Principal principal) {

        UserEntity user = userService.findByLogin(principal.getName());
        model.addAttribute("tasks", user.getTasks());

        return "task/taskList";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model, HttpSession session) {

        ToDoListModel task = new ToDoListModel();
        model.addAttribute("task", task);

        return "task/taskForm";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("taskId") int id, Model model) {

        ToDoListEntity task = toDoListService.findById(id);

        ToDoListModel toDoListModel = new ToDoListModel();
        toDoListModel.setId(task.getId());
        toDoListModel.setShortDescription(task.getShortDescription());
        toDoListModel.setDetailedDescription(task.getDetailedDescription());

        model.addAttribute("task", toDoListModel);

        return "task/taskForm";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("taskId") int id) {
        toDoListService.deleteById(id);

        return "redirect:/tasks/list";
    }

    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("task") ToDoListModel task,
                              BindingResult bindingResult,
                              Principal principal) {

        if(bindingResult.hasErrors()) {
            return "task/taskForm";
        }

        ToDoListEntity toDoListEntity = new ToDoListEntity();
        toDoListEntity.setId(task.getId());
        toDoListEntity.setShortDescription(task.getShortDescription());
        toDoListEntity.setDetailedDescription(task.getDetailedDescription());
        toDoListEntity.setUser(userService.findByLogin(principal.getName()));

        toDoListService.save(toDoListEntity);

        return "redirect:/tasks/list";
    }
}
