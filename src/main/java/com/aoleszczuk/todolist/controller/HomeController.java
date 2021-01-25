package com.aoleszczuk.todolist.controller;

import com.aoleszczuk.todolist.entity.UserEntity;
import com.aoleszczuk.todolist.model.PasswordModel;
import com.aoleszczuk.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "home/loginPage";
    }

    @GetMapping("/home")
    public String homePage(Model model, Principal principal) {
        model.addAttribute("user", userService.findByLogin(principal.getName()));

        return "home/homePage";
    }

    @GetMapping("/register")
    public String registrationPage(Model model) {
        model.addAttribute("user", new UserEntity());

        return "home/registrationPage";
    }

    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") UserEntity user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "home/registrationPage";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);

        return "redirect:/login";
    }


    @GetMapping("/showFormForUserUpdate")
    public String showFormForUpdate(Model model, Principal principal){

        UserEntity user = userService.findByLogin(principal.getName());
        model.addAttribute("user", user);

        return "home/updateUserPage";
    }

    @PostMapping("/update")
    public String userUpdate(@Valid @ModelAttribute("user") UserEntity user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "home/updateUserPage";
        }

        userService.save(user);

        return "redirect:/home";
    }

    @GetMapping("/showFormForChangePassword")
    public String showFormForChangePassword(Model model){

        PasswordModel password = new PasswordModel();
        model.addAttribute("password", password);

        return "home/changePasswordPage";
    }

    @PostMapping("/changePassword")
    public String changePassword(@Valid @ModelAttribute("password") PasswordModel password,
                                 BindingResult bindingResult,
                                 Model model,
                                 Principal principal) {

        if(bindingResult.hasErrors()) {
            return "home/changePasswordPage";
        }

        UserEntity user = userService.findByLogin(principal.getName());

        if(!password.getNewPassword().equals(password.getRepeatedPassword())){
            model.addAttribute("hasErrors", "true");
            model.addAttribute("errorMessage", "The password in both fields must be the same.");
        }
        else if(!passwordEncoder.matches(user.getPassword(), password.getOldPassword())){
            model.addAttribute("hasErrors", "true");
            model.addAttribute("errorMessage", "Wrong old password");
        }
        else {
            model.addAttribute("hasErrors", "false");
            user.setPassword(passwordEncoder.encode(password.getNewPassword()));
            userService.save(user);
        }

        return "home/changePasswordPage";
    }
}
