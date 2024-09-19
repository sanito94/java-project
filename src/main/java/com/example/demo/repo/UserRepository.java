package com.example.demo.repo;

import com.example.demo.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<Employee, Integer> {
//    @Query("SELECT employee from  Employee employee order by employee.lastName asc")
//    List<Employee> findAllByLastName();

    List<Employee> findAllByOrderByLastNameAscDateOfBirthAsc();
}
