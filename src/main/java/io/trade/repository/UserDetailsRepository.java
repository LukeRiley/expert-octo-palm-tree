package io.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.trade.model.*;;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Integer> {
	
	List<UserDetails> findAll();
	List<UserDetails> findByUsers(Users user);
}

