package io.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.trade.model.*;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoles, Integer> {
	
	List<UserRoles> findAll();
	List<UserRoles> findByUsers(Users user);
}

