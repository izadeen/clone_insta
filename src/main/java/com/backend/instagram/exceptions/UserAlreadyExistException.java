package com.backend.instagram.exceptions;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String msg){
        super(msg);
    }
}
