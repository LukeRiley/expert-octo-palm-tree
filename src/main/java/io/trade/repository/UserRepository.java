package io.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.trade.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	List<User> findAll();
	
}

