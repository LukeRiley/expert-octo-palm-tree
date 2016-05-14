package io.trade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.trade.model.UserDetails;
import io.trade.model.UserRoles;
import io.trade.model.Users;
import io.trade.repository.UserDetailsRepository;
import io.trade.repository.UserRoleRepository;
import io.trade.repository.UsersRepository;
@Service
public class UserServiceImpl implements UserService {

	private final UsersRepository users;
	private final UserRoleRepository roles;
	private final UserDetailsRepository details;
	private final DatabaseService database;

	@Autowired
	public UserServiceImpl(UsersRepository users, UserRoleRepository roles, UserDetailsRepository details,
			DatabaseService db) {
		this.users = users;
		this.roles = roles;
		this.details = details;
		this.database = db;
		this.database.setUsers(this);
	}

	@Override
	public List<UserDetails> findAllDetails() {
		return details.findAll();
	}

	@Override
	public UserDetails findDetailsByUser(Users user) {
		List<UserDetails> d = details.findByUsers(user);
		if(d.isEmpty())
			return null;
		return d.get(0);
	}

	@Override
	public void addDetails(UserDetails userDetails) {
		details.save(userDetails);
	}

	@Override
	public List<UserRoles> findAllRoles() {
		return roles.findAll();
	}

	@Override
	public UserRoles findRolesByUser(Users user) {
		List<UserRoles> r = roles.findByUsers(user);
		if(r.isEmpty())
			return null;
		return r.get(0);
	}

	@Override
	public void addRoles(UserRoles userRoles) {
		roles.save(userRoles);
	}

	@Override
	public List<Users> findAll() {
		return users.findAll();
	}

	@Override
	public Users findByUserName(String userName) {
		List<Users> r = users.findByUserName(userName);
		if(r.isEmpty())
			return null;
		return r.get(0);
	}

	@Override
	public void add(Users user) {
		users.save(user);
	}

}
