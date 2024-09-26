package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Size(min=2, max=20, message = "Firstname must be between 2 and 20 characters")
    @NotNull(message = "can not be null")
    @NotBlank(message = "can not be blank")
    @Column(name="firstName")
    private String firstName;

    @Size(min=2, max=20, message = "Lastname must be between 2 and 20 characters")
    @NotNull(message = "can not be null")
    @NotBlank(message = "can not be blank")
    @Column(name="lastName")
    private String lastName;

    @Past
    @Column(name="dateOfBirth")
    private Date dateOfBirth;

    @Pattern(regexp = "(\\+359|0)[0-9]{9}")
    @NotNull(message = "can not be null")
    @NotBlank(message = "can not be blank")
    @Column(name="phoneNumber")
    private String phoneNumber;

    @NotNull(message = "can not be null")
    @NotBlank(message = "can not be blank")
    @Email(message = "Email should be valid")
    @Column(name="email")
    private String email;
}
