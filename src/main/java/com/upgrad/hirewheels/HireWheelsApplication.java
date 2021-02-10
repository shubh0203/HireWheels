package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.UserDao;
import com.upgrad.hirewheels.entities.Role;
import com.upgrad.hirewheels.entities.User;
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
		UserDao userDao = context.getBean(UserDao.class);

		Role roleA=new Role();
		roleA.setRoleName("ADMIN");
		Role roleU=new Role();
		roleU.setRoleName("USER");



		User user1 = new User();
		user1.setFirstName("Shubham");
		user1.setLastName("Bhosale");
		user1.setPassword("shubham1");
		user1.setEmail("shubhambhosale@gmail.com");
		user1.setMobileNo("9966825142");
		user1.setWalletMoney(12220.78);
		user1.setRole(roleA);

		User user2 = new User();
		user2.setFirstName("Vijay");
		user2.setLastName("Jadhav");
		user2.setPassword("vijay1");
		user2.setEmail("vijayjadhav@gmail.com");
		user2.setMobileNo("7548136351");
		user2.setWalletMoney(11500.67);
		user2.setRole(roleU);

		User user3 = new User();
		user3.setFirstName("Sumit");
		user3.setLastName("Dhavale");
		user3.setPassword("sumit1");
		user3.setEmail("sumitdhavale@gmail.com");
		user3.setMobileNo("9865741523");
		user3.setWalletMoney(15687.53);
		user3.setRole(roleU);

		User user4 = new User();
		user4.setFirstName("Sopan");
		user4.setLastName("Surve");
		user4.setPassword("sopan1");
		user4.setEmail("sopansurve@gmail.com");
		user4.setMobileNo("8658742368");
		user4.setWalletMoney(18900.67);
		user4.setRole(roleU);

		User user5 = new User();
		user5.setFirstName("Ashish");
		user5.setLastName("Shinde");
		user5.setPassword("ashish1");
		user5.setEmail("ashishshinde@gmail.com");
		user5.setMobileNo("7588254865");
		user5.setWalletMoney(23560.82);
		user5.setRole(roleU);


		userDao.saveAll(List.of(user1,user2,user3,user4,user5));

		userDao.findAll().forEach(user -> System.out.println(user));

		System.out.println("*************Finding first page of User*************");
		Page<User> page0 = userDao.findAll(PageRequest.of(0, 2));
		page0.stream().forEach(user -> System.out.println(user));

		System.out.println("*************Finding second page of User*************");
		Page<User> page1 = userDao.findAll(PageRequest.of(1, 2));
		page1.stream().forEach(user -> System.out.println(user));

		System.out.println("*************find by FirstName*************");
		userDao.findByFirstName("Shubham")
				.forEach(user -> System.out.println(user));

		System.out.println("*************find by FirstName or LastName*************");
		userDao.findByFirstNameOrLastName("Vijay","Jadhav")
				.forEach(user -> System.out.println(user));

		System.out.println("*************find by Email Id*************");
		userDao.findByEmail("sumitdhavale@gmail.com")
				.forEach(user -> System.out.println(user));

		System.out.println("*************find by mobile number*************");
		userDao.findByMobileNo("8658742368")
				.forEach(user -> System.out.println(user));
	}

}
