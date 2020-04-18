package com.Deadlybeat.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Deadlybeat.model.User;

public interface Shoppismrepository extends MongoRepository<User, Integer>{


	/* created for search by user name
	 * no need to write query as name is from same user model
	 * */
	List<User> findByName(String name);


	/* created for search by user city
	 * we have to write a query as city is of from another model Address 
	 * and user model has the address model in it
	 * here no need to write join statement as we need to write in traditional JPA
	 * Address.city column 
	 * ? stands replaced by method parameter during runtime which will be coming from user, 
	 * 0 stands for the oth index
	 * */
	@Query("{'Address.city':?0}")
	List<User> findByCity(String city);

}
