package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee user1 = new Employee();
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setEmail("john@doe.com");
        user1.setPhoneNumber("1234567890");
        user1.setDateOfBirth(Date.valueOf("1993-07-21"));
        userRepository.save(user1);


        Employee user2 = new Employee();
        user2.setFirstName("Mitko");
        user2.setLastName("Muglata");
        user2.setEmail("muglata@doe.com");
        user2.setPhoneNumber("1111122334");
        user2.setDateOfBirth(Date.valueOf("2000-03-11"));
        userRepository.save(user2);
    }
}
