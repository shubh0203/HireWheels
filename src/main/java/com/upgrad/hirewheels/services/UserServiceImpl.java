package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import com.upgrad.hirewheels.exceptions.UserAlreadyExitsException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements  UserService{
    
    @Autowired
    RoleDao roleDao;

    @Autowired
    UserDao userDao;

    @Override
    public User getUserDetails(int id) throws UserDetailsNotFoundException {
        return userDao.findById(id)
                .orElseThrow(
                        () -> new UserDetailsNotFoundException("Booking not found for id: " + id)
                );
    }
    
    @Override
    public User createUser(User user) throws UserAlreadyExitsException {
        if (userDao.findByEmail(user.getEmail())!=null) {
            throw new UserAlreadyExitsException("Email Already Exists");
        }
        if (userDao.findByMobileNo(user.getMobileNo())!=null) {
            throw new UserAlreadyExitsException("Mobile Number Already Exists");
        }
        User user1=userDao.save(user);
        System.out.println(user1);
        return user1;
    }

    @Override
    public User getUser(String emailId, String password) throws UserAlreadyExitsException{
        if(userDao.findByEmail(emailId)!=null){
            if(userDao.findByEmail(emailId).getPassword().equals(password)){
                return (User) userDao.findByEmail(emailId);
            }else {
                throw new UserAlreadyExitsException("Unauthorized User");
            }
        }else {
            throw new UserAlreadyExitsException("User not Registered");
        }
    }

}
