package io.trade.service;

import java.util.List;

import io.trade.model.UserDetails;
import io.trade.model.UserRoles;
import io.trade.model.Users;

public interface UserService {

	List<UserDetails> findAllDetails();

	UserDetails findDetailsByUser(Users user);

	void addDetails(UserDetails userDetails);

	List<UserRoles> findAllRoles();

	UserRoles findRolesByUser(Users user);

	void addRoles(UserRoles userRoles);

	List<Users> findAll();

	Users findByUserName(String userName);

	void add(Users user);

}
