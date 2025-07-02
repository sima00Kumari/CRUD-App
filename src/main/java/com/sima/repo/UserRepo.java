package com.sima.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sima.entity.User;

import jakarta.transaction.Transactional;

public interface UserRepo extends CrudRepository<User,Integer>{
	
	@Query("From User")
	public List<User> getAllUser();
	
	@Query(value ="select * from user_details", nativeQuery=true)
	public List<User> getAllUsers();
	
	  //For INSERT, HQL does not support entity insert statements like 
	//INSERT INTO EntityName(...), so use SQL native queries instead.
	    @Modifying
	    @Transactional
	    @Query(value = "INSERT INTO User_Details (id,user_name, gender, country) VALUES (:id, :user_name, :gender, :country)", nativeQuery = true)
	    void insertUser(@Param("id") Integer id, @Param("user_name") String name,
                @Param("gender") String gender, @Param("country") String country);

	    @Modifying
	    @Transactional
	    @Query("UPDATE User u SET u.country = :country WHERE u.name = :name")
	    int updateCountryByName(@Param("name") String name, @Param("country") String country);

	    @Modifying
	    @Transactional
	    @Query("DELETE FROM User u WHERE u.name = :name")
	    int deleteByName(@Param("name") String name);
	
	// select * from User where country=?
	public List<User> findByCountry(String country);
	
	//select * from User where country=? and gender=?
	public List<User> findByCountryAndGender(String country, String gender);
	
}
