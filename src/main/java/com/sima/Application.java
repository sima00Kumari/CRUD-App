package com.sima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sima.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		// IOC will start
		ConfigurableApplicationContext context = 
				SpringApplication.run(Application.class, args);
		
		// get bean object
		UserService bean = context.getBean(UserService.class);
		
		// Calling bean Method 
		bean.saveUser();
		bean.saveUsers();
		bean.getAllUsers();
		bean.deleteAllUsers();
		bean.getUserById(1019);
		bean.findUserByCountry("UK");
		bean.findUserByCountryAndGender("USA", "Male");
		bean.getAllUserHQL();
		bean.getAllUserSQL();
		bean.addUser(105, "Sima", "Female", "India");
		bean.updateUser("Sima", "UK");
		bean.deleteUser("Sima");
	}

}
