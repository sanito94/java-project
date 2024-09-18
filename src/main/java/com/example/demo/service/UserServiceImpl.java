package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Employee createUser(Employee user) {
        return userRepository.save(user);
    }

    @Override
    public Employee getUserById(int id) {
        return  userRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getUsers() {
        return userRepository.findAllByLastName();
    }

    @Override
    public Employee updateUser(Employee user) {
        Employee oldUser = null;

        Optional<Employee> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            oldUser = optionalUser.get();
            oldUser.setFirstName(user.getFirstName());
            oldUser.setLastName(user.getLastName());
            userRepository.save(oldUser);
        } else {
            oldUser = new Employee();
            userRepository.save(oldUser);
        }
        return oldUser;
    }

    @Override
    public String deleteUserById(int id) {
        userRepository.deleteById(id);
        return "User deleted";
    }
}
