package com.sn.carpooling.exception;

public class UserNotExistException extends RuntimeException {
    private String name;

    public UserNotExistException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
