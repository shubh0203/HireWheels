package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    List<User> findByFirstName(String firstName);
    List<User> findByFirstNameOrLastName(String firstName, String lastName);
    List<User> findByEmail(String email);
    List<User> findByMobileNo(String mobileNo);
}
