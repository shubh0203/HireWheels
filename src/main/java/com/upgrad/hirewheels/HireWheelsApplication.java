package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.*;
//import com.upgrad.hirewheels.dao.UserDao;
import com.upgrad.hirewheels.entities.*;
//import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.services.initService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootApplication
public class HireWheelsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
		initService initService= context.getBean(initService.class);
		initService.start();

	}

}
