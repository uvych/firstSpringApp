package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/users")
    public String getAllUser(Model model){
        model.addAttribute("users",userService.findAll());
        return "usersList";
    }

    @GetMapping("/user/{id}")
    public String getById(@PathVariable("id") int id, Model model){
        model.addAttribute("user",userService.getById(id));
        return "showUser";
    }

    @GetMapping("/addUser")
    public String creatUserPage(){
        return "createUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id , Model model){
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/user/"+ user.getId();
    }


}
