package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.UserRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
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
        return  userRepository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<Employee> getUsers() {
        return userRepository.findAllByOrderByLastNameAscDateOfBirthAsc();
    }


    @Override
    public Employee updateUser(int id, Employee user) {
        Employee oldUser = null;

        Optional<Employee> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            oldUser = optionalUser.get();
            oldUser.setFirstName(user.getFirstName());
            oldUser.setLastName(user.getLastName());
            oldUser.setDateOfBirth(user.getDateOfBirth());
            oldUser.setPhoneNumber(user.getPhoneNumber());
            oldUser.setEmail(user.getEmail());
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

    @Override
    public List<Employee> searchUsers(String searchTerm) {
        return userRepository.findByFirstNameContainingOrEmailContainingOrLastNameContaining(searchTerm, searchTerm, searchTerm);
    }
}
