package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface UserService {
    Employee createUser(Employee user);

    Employee getUserById(int id);

    List<Employee> getUsers();

    Employee updateUser(Employee user);

    String deleteUserById(int id);
}
