package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(int id);

    List<User> getUsers();

    User updateUser(int id, User user);

    String deleteUserById(int id);

    List<User> searchUsers(String searchTerm);

    Page<User> findAllUsersByPage(PageRequest pageable);
}
