package com.example.demo.data;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class SampleDataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setEmail("john@doe.com");
        user1.setPhoneNumber("+359164327841");
        user1.setDateOfBirth(Date.valueOf("1993-07-21"));
        userRepository.save(user1);


        User user2 = new User();
        user2.setFirstName("Mitko");
        user2.setLastName("Muglata");
        user2.setEmail("muglata@doe.com");
        user2.setPhoneNumber("+359123456789");
        user2.setDateOfBirth(Date.valueOf("2000-03-11"));
        userRepository.save(user2);
    }
}
