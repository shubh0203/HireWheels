package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exceptions.UserAlreadyExitsException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;

public interface UserService {
    User createUser(User users) throws UserAlreadyExitsException;
    public User getUserDetails(int id) throws UserDetailsNotFoundException;
    public User getUser(String emailId, String password) throws UserAlreadyExitsException;
}
