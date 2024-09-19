package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Employee addUser(@RequestBody Employee user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public Employee getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<Employee> getAllUsers() {
        return userService.getUsers();
    }

    @PutMapping("/{id}")
    public Employee updateUser(@PathVariable int id, @RequestBody Employee user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUserById(id);
    }
}
