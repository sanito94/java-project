package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.UsersNotFoundError;
import com.example.demo.repository.UserRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        return  userRepository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAllByOrderByLastNameAscDateOfBirthAsc();
        if (users.isEmpty()) {
            throw new UsersNotFoundError("Users not found");
        } else {
            return users;
        }
    }


    @Override
    public User updateUser(int id, User user) {
        User oldUser = null;

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            oldUser = optionalUser.get();
            oldUser.setFirstName(user.getFirstName());
            oldUser.setLastName(user.getLastName());
            oldUser.setDateOfBirth(user.getDateOfBirth());
            oldUser.setPhoneNumber(user.getPhoneNumber());
            oldUser.setEmail(user.getEmail());
            userRepository.save(oldUser);
        } else {
            oldUser = new User();
            userRepository.save(oldUser);
        }
        return oldUser;
    }

    @Override
    public String deleteUserById(int id) {
        User user = getUserById(id);

        if (user != null) {
            userRepository.deleteById(id);
            return "User with id " +  id  + " deleted";
        } else {
            throw new UsersNotFoundError("User not found with id: " + id);
        }
    }

    @Override
    public List<User> searchUsers(String searchTerm) {
        return userRepository.findByFirstNameContainingOrEmailContainingOrLastNameContaining(searchTerm, searchTerm, searchTerm);
    }

    @Override
    public Page<User> findAllUsersByPage(PageRequest pageable) {
        return userRepository.findAll(pageable);
    }
}
