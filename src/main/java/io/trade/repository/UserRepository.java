package io.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.trade.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
	
	List<Users> findAll();
	List<Users> findByUserName(String name);
	
}

