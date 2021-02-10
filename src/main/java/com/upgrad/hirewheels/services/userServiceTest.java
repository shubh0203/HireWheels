package com.upgrad.hirewheels.services;


import com.upgrad.hirewheels.dao.RoleDao;
import com.upgrad.hirewheels.dao.UserDao;
import com.upgrad.hirewheels.entities.*;
import com.upgrad.hirewheels.exceptions.UserAlreadyExitsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class userServiceTest {

    @Mock
    UserDao usersDao;

    @Mock
    RoleDao roleDao;


    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    public void setUpMockito(){
        //Mockito.when(roleDao.save(new
        // Role(1,"save test")).thenReturn(new Role(1,"save test")));
        Mockito.when(roleDao.findById(1)).thenReturn(new Role(1,"save test"));

        Mockito.when(usersDao.save(new User(1,"save test","save test","save test",
                "save test","save test",10, new Role(1,"save test")))).thenReturn(new User(1,"save test","save test","save test",
                "save test","save test",10,new Role(1,"save test")));

        Mockito.when(usersDao.save(new User())).thenReturn(new User(1,"save test","save test","save test",
                "save test","save test",10,new Role(1,"save test")));

        Mockito.when(usersDao.findById(1)).thenReturn(Optional.of(new User(1,"save test","save test","save test",
                "save test1","save test1",10,new Role(1,"save"))));

        Mockito.when(usersDao.findByMobileNo("save test1")).thenReturn(new User(1,
                "save test","save test","save test",
                "save test1","save test1",10,new Role(1,"save test")));

        Mockito.when(usersDao.findByEmail("save test1")).thenReturn(new User(1,
                "save test","save test","save test",
                "save test1","save test1",10,new Role(1, "save test")));

    }

    @Test
    public void testCreateUser() throws UserAlreadyExitsException {
        Role role=new Role();
        role.setRoleName("save test");
        User user= new User();
        user.setFirstName("save test");
        user.setWalletMoney(10);
        user.setPassword("save test");
        user.setRole(role);
        user.setMobileNo("save test");
        user.setEmail("save test");
        user.setLastName("save test");

        User savedUser= userService.createUser(user);
        System.out.println(savedUser);
        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getUserid() != 0);
        Assertions.assertEquals("save test", savedUser.getFirstName());
        Assertions.assertEquals("save test", savedUser.getLastName());
        Assertions.assertEquals("save test", savedUser.getPassword());
        Assertions.assertEquals("save test", savedUser.getEmail());
        Assertions.assertEquals("save test", savedUser.getMobileNo());
        Assertions.assertEquals(10, savedUser.getWalletMoney());
        Assertions.assertEquals("save test", savedUser.getRole().getRoleName());

    }
    @Test
    public void testGetUser() throws UserAlreadyExitsException {
        User getUser= userService.getUser("save test1", "save test");

        Assertions.assertNotNull(getUser);
        Assertions.assertTrue(getUser.getUserid() != 0);
        Assertions.assertEquals("save test", getUser.getFirstName());
        Assertions.assertEquals("save test", getUser.getLastName());
        Assertions.assertEquals("save test", getUser.getPassword());
        Assertions.assertEquals("save test1", getUser.getEmail());
        Assertions.assertEquals("save test1", getUser.getMobileNo());
        Assertions.assertEquals(10, getUser.getWalletMoney());
        Assertions.assertEquals("save test", getUser.getRole().getRoleName());

    }

}
