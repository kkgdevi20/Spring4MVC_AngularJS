package com.gayathri.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gayathri.springmvc.model.User;
import com.gayathri.springmvc.repository.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	// All Users in DataBase
	public List<User> findAllUsers() {
		System.out.println("Retriving all users");
		List<User> users = userRepository.findAll();
		return users;
		
	}
	
	//Get User given their Id
	public User findById(Long id) {		
		User user = userRepository.findById(id);
		return user;
		
	}
	
	//Get User given their User Name
	public User findByName(String username) {
		System.out.println("find by name: "+username);
		User searchedByUserName = userRepository.findByUsername(username);
		return searchedByUserName;
	}
	
	//Insert user
	public void saveUser(User user) {
		Long id = 1L;
		User userWithMaxId =userRepository.findOne();
		if(userWithMaxId != null){
			id = userWithMaxId.getId()+1; 
		}
		user.setId(id);
		userRepository.save(user); // CrudRepository
	}

	// Update record of a Customer given their ID
	public void updateUser(User user) {		
		userRepository.save(user);
	}

	// Delete a User given his ID	
	public void deleteUserById(Long id) {		
		userRepository.delete(findById(id));
		System.out.println("user with id "+ id + " is deleted");
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		userRepository.deleteAll();
	}


}
