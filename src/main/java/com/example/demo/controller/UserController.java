package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Employee addUser(@Valid @RequestBody Employee user) {
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

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchUsers(@RequestParam String searchTerm) {
        List<Employee> employees = userService.searchUsers(searchTerm);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
