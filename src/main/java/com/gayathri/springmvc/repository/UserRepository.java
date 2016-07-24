package com.gayathri.springmvc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gayathri.springmvc.model.User;



public interface UserRepository extends MongoRepository<User, String> {
	 
	public User findByUsername(@Param("username") String username);
	
	@Query("{ '_id' : ?0 }")
    User findById(@Param("id") Long id);	
	
	@Query("{},$orderby:{'_id': -1}")
	User findOne();
	
}
