package io.trade.controller;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import io.trade.model.*;
import io.trade.service.DatabaseService;


/*
 * This is just a test/mock controller that will not be in the final release
 */
/**
 * @author Luke Riley
 *
 */
@Controller
public class IndexController {
	
	private Users user1;
	private Users user2;
	
	private final DatabaseService database;

	@Autowired
	public IndexController(DatabaseService db) {
		this.database = db;
	}
	
	@RequestMapping(value = "/")
	public String index() {
		addUsers();
		addOthers();
		return "home";
	}
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	private void addUsers(){
		user1 = new Users("admin", "admin", 1);
		UserRoles ur1 = new UserRoles(user1, "ROLE_ADMIN");
		UserDetails ud1 = new UserDetails("John Doe", "I am me", user1);
		database.addUsers(user1);
		database.addUserRoles(ur1);
		database.addUserDetails(ud1);
		user2 = new Users("user", "user", 1);
		UserRoles ur2 = new UserRoles(user2, "ROLE_USER");
		UserDetails ud2 = new UserDetails("Joe Blogs", "Hi all my name is...etc", user2);
		database.addUsers(user2);
		database.addUserRoles(ur2);
		database.addUserDetails(ud2);
	}
	
	private void addOthers(){
		Category c = new Category("sport");
		database.addCategory(c);
		Item i = new Item("ball", "soccer ball, childs", c);
		database.addItem(i);
		Instant instant = Instant.now();
		Auction a1 = new Auction(instant.minus(Duration.ofDays(15)), instant.minus(Duration.ofDays(5)), i, user1);
		database.addAuction(a1);
		Auction a2 = new Auction(instant.minus(Duration.ofDays(5)), instant.plus(Duration.ofDays(5)), i, user1);
		database.addAuction(a2);
		Bid b = new Bid(54.50, instant, user1, a2);
		database.addBid(b);
	}
}