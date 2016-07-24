package com.gayathri.springmvc.service;

import java.util.List;

import com.gayathri.springmvc.model.User;



public interface UserService {
	
	User findById(Long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(Long id);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
}
