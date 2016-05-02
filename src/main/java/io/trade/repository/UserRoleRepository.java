package io.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.trade.model.UserRole;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
	
	List<UserRole> findAll();
	
}

