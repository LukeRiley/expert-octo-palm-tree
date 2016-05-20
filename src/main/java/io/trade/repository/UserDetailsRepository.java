package io.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.trade.model.*;;

@Repository
public interface UserDetailsRepository extends CrudRepository<UsersDetails, Integer> {
	
	List<UsersDetails> findAll();
	List<UsersDetails> findByUsers(Users user);
}

