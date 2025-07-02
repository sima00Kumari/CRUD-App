package com.sima.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sima.entity.User;
import com.sima.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	public void saveUsers() {

		User u1 = new User();
		u1.setId(101);
		u1.setName("Ashok");
		u1.setGender("Male");
		u1.setCountry("USA");

		User u2 = new User();
		u2.setId(103);
		u2.setName("John");
		u2.setGender("Male");
		u2.setCountry("UK");

		User u3 = new User();
		u3.setId(104);
		u3.setName("Sita");
		u3.setGender("Fe-Male");
		u3.setCountry("Japan");

		List<User> usersList = Arrays.asList(u1,u2,u3);
		userRepo.saveAll(usersList);

	}
	
	public void deleteAllUsers() {
		userRepo.deleteAll();
	}

	public void saveUser() {

		User u = new User();
		u.setId(102);
		u.setName("Sima");
		u.setGender("FeMale");
		u.setCountry("USA");

		userRepo.save(u); // UPSERT
	}
	
	public void getAllUsers() {
		Iterable<User> all = userRepo.findAll();
		all.forEach(u -> {
			System.out.println(u);
		});
	}
	
	public void getUserById(Integer uid) {
		Optional<User> byId = userRepo.findById(uid);
		if(byId.isPresent()) {
			System.out.println(byId.get());
		} else {
			System.out.println("Record not found");
		}
	}
	
	public void findUserByCountry(String country) {
		List<User> byCountry = userRepo.findByCountry(country);
		byCountry.forEach(System.out::println);
	}
	
	public void findUserByCountryAndGender(String country, String gender) {
		List<User> byCountryAndGender = userRepo.findByCountryAndGender(country, gender);
		byCountryAndGender.forEach(System.out::println);

	}
	
	public void getAllUserHQL() {
		List<User> allUser = userRepo.getAllUser();
		allUser.forEach(System.out::println);	
	}
	
	public void getAllUserSQL() {
		List<User> allUser = userRepo.getAllUsers();
		allUser.forEach(System.out::println);	
	}
	// insert using custom query
    public void addUser(Integer id, String name, String gender, String country) {
    	userRepo.insertUser(id, name, gender, country);
    }
    
    // Update Using HQL Custom query
    public void updateUser(String name, String Country) {
    	userRepo.updateCountryByName(name, Country);
    }

 // Delete Using HQL Custom query
    public void deleteUser(String name) {
    	userRepo.deleteByName(name);
    }

}
