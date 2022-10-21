package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping()
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", service.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String getUsers(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", service.findUser(id));
        return "/view";
    }

    @GetMapping("/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String updateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", service.findUser(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        service.updateUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable("id") int id) {
        service.deleteUser(id);
        return "redirect:/";
    }
}