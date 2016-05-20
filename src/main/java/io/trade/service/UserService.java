package io.trade.service;

import java.util.List;

import io.trade.model.UsersDetails;
import io.trade.model.UserRoles;
import io.trade.model.Users;

public interface UserService {

	List<UsersDetails> findAllDetails();

	UsersDetails findDetailsByUser(Users user);

	void addDetails(UsersDetails usersDetails);

	List<UserRoles> findAllRoles();

	UserRoles findRolesByUser(Users user);

	void addRoles(UserRoles userRoles);

	List<Users> findAll();

	Users findByUserName(String userName);

	void add(Users user);

}
