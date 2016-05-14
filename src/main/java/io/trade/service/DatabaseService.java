package io.trade.service;

import java.util.List;

import io.trade.model.*;

public interface DatabaseService {

	// Auction

	public List<Auction> findAllAuction();

	public List<Auction> findAuctionByUser(Users user);
	
	public List<Auction> findAuctionByItem(Item item);
	
	public List<Auction> findAuctionBySearch(String search);

	public void addAuction(Auction auction);

	// Bid

	public List<Bid> findAllBid();

	public List<Bid> findBidByAuction(Auction auction);

	public List<Bid> findBidByUser(Users user);

	public void addBid(Bid bid);

	// Category

	public List<Category> findAllCategory();

	public List<Category> findCategoryByName(String name);

	public void addCategory(Category category);

	// Item

	public List<Item> findAllItem();

	public List<Item> findItemByUser(Users user);
	
	public List<Item> findItemBySearch(String search);

	public void addItem(Item item);

	// UserDetails

	public List<UserDetails> findAllUserDetails();

	public UserDetails findUserDetailsByUser(Users user);

	public void addUserDetails(UserDetails userDetails);

	// UserRoles

	public List<UserRoles> findAllUserRoles();

	public UserRoles findUserRolesByUser(Users user);

	public void addUserRoles(UserRoles userRoles);

	// Users

	public List<Users> findAllUsers();

	public Users findUsersByUserName(String userName);

	public void addUsers(Users user);

	// Utility
	
	void setAuctions(AuctionService auctions);

	void setBids(BidService bids);

	void setCategories(CategoryService categories);

	void setItems(ItemService items);

	void setUsers(UserService users);
}
