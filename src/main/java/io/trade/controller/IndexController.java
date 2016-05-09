package io.trade.controller;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.trade.model.Users;
import io.trade.model.Auction;
import io.trade.model.Bid;
import io.trade.model.Category;
import io.trade.model.Item;
import io.trade.model.UserDetails;
import io.trade.model.UserRoles;
import io.trade.repository.*;


/*
 * This is just a test/mock controller that will not be in the final release
 */
/**
 * @author Luke Riley
 *
 */
@Controller
public class IndexController {
	
	@Autowired
	UsersRepository users;
	
	@Autowired
	UserRoleRepository userRoles;
	
	@Autowired
	AuctionRepository auctions;
	
	@Autowired
	BidRepository bids;
	
	@Autowired
	CategoryRepository categories;
	
	@Autowired
	ItemRepository items;
	
	@Autowired
	UserDetailsRepository userDetails;
	
	private Users user1;
	private Users user2;
	
	@RequestMapping(value = "/home")
	public String index() {
		addUsers();
		addOthers();
		return "home";
	}

	private void addUsers(){
		user1 = new Users("admin", "admin", 1);
		UserRoles ur1 = new UserRoles(user1, "ROLE_ADMIN");
		UserDetails ud1 = new UserDetails("John Doe", "I am me", user1);
		users.save(user1);
		userRoles.save(ur1);
		userDetails.save(ud1);
		user2 = new Users("user", "user", 1);
		UserRoles ur2 = new UserRoles(user2, "ROLE_USER");
		UserDetails ud2 = new UserDetails("Joe Blogs", "Hi all my name is...etc", user2);
		users.save(user2);
		userRoles.save(ur2);
		userDetails.save(ud2);
	}
	
	private void addOthers(){
		Category c = new Category("sport");
		categories.save(c);
		Item i = new Item("ball", "soccer ball, childs", c);
		items.save(i);
		Instant instant = Instant.now();
		Auction a1 = new Auction(instant.minus(Duration.ofDays(15)), instant.minus(Duration.ofDays(5)), i, user1);
		auctions.save(a1);
		Auction a2 = new Auction(instant.minus(Duration.ofDays(5)), instant.plus(Duration.ofDays(5)), i, user1);
		auctions.save(a2);
		Bid b = new Bid(54.50, instant, user1, a2);
		bids.save(b);
	}
}