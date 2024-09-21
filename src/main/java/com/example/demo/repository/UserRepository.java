package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByOrderByLastNameAscDateOfBirthAsc();

    List<Employee> findByFirstNameContainingOrEmailContainingOrLastNameContaining(String firstName, String email, String lastName);
}
