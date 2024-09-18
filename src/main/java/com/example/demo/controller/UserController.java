package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public Employee addUser(@RequestBody Employee user) {
        return userService.createUser(user);
    }

    @GetMapping("/user/{id}")
    public Employee getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/allUsers")
    public List<Employee> getAllUsers() {
        return userService.getUsers();
    }

    @PutMapping("/updateUser")
    public Employee updateUser(@RequestBody Employee user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUserById(id);
    }
}
