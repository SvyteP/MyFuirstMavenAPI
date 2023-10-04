package com.example.MyFuirstMavenAPI.exeption;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
