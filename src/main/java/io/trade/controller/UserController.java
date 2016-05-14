package io.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.trade.model.*;
import io.trade.service.DatabaseService;

public class UserController {

	private final DatabaseService database;

	@Autowired
	public UserController(DatabaseService db) {
		this.database = db;
	}

	@RequestMapping(value = "/login/details/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> findAllDetails(){
		return new ResponseEntity<List<UserDetails>>(database.findAllUserDetails(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login/details/user", method = RequestMethod.GET)
	public ResponseEntity<UserDetails> findDetailsByUser(@RequestBody Users user){
		return new ResponseEntity<UserDetails>(database.findUserDetailsByUser(user), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login/details/add", method = RequestMethod.POST, consumes = "application/json")
	public void addDetails(@RequestBody UserDetails details){
		database.addUserDetails(details);
	}
	//--------------
	@RequestMapping(value = "/login/roles/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> findAllRoles(){
		return new ResponseEntity<List<UserDetails>>(database.findAllUserDetails(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login/roles/user", method = RequestMethod.GET)
	public ResponseEntity<UserRoles> findRolesByUser(@RequestBody Users user){
		return new ResponseEntity<UserRoles>(database.findUserRolesByUser(user), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login/roles/add", method = RequestMethod.POST, consumes = "application/json")
	public void addRoles(@RequestBody UserRoles roles){
		database.addUserRoles(roles);
	}
	//---------------
	@RequestMapping(value = "/login/user/all", method = RequestMethod.GET)
	public ResponseEntity<List<Users>> findAll(){
		return new ResponseEntity<List<Users>>(database.findAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login/user/user", method = RequestMethod.GET)
	public ResponseEntity<Users> findUserByUserName(@RequestBody String name){
		return new ResponseEntity<Users>(database.findUsersByUserName(name), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login/user/add", method = RequestMethod.POST, consumes = "application/json")
	public void add(@RequestBody Users user){
		database.addUsers(user);
	}
}
