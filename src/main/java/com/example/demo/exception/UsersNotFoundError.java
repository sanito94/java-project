package com.example.demo.exception;

public class UsersNotFoundError extends RuntimeException {
    public UsersNotFoundError(String message) {
        super(message);
    }
}
