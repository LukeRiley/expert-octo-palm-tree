package io.trade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.trade.model.Auction;
import io.trade.model.Bid;
import io.trade.model.Category;
import io.trade.model.Item;
import io.trade.model.UserDetails;
import io.trade.model.UserRoles;
import io.trade.model.Users;

@Service
public class DatabaseServiceImpl implements DatabaseService {

	private AuctionService auctions = null;
	private BidService bids = null;
	private CategoryService categories = null;
	private ItemService items = null;
	private UserService users = null;

	public DatabaseServiceImpl() {
	}

	@Override
	public List<Auction> findAllAuction() {
		return auctions.findAll();
	}

	@Override
	public List<Auction> findAuctionByUser(Users user) {
		return auctions.findByUser(user);
	}

	@Override
	public List<Auction> findAuctionByItem(Item item) {
		return auctions.findByItem(item);
	}

	@Override
	public List<Auction> findAuctionByCategory(Category category) {
		return auctions.findByCategory(category);
	}

	@Override
	public List<Auction> findAuctionBySearch(String search) {
		return auctions.findBySearch(search);
	}

	@Override
	public void addAuction(Auction auction) {
		auctions.add(auction);
	}

	@Override
	public List<Bid> findAllBid() {
		return bids.findAll();
	}

	@Override
	public List<Bid> findBidByAuction(Auction auction) {
		return bids.findByAuction(auction);
	}

	@Override
	public List<Bid> findBidByUser(Users user) {
		return bids.findByUser(user);
	}

	@Override
	public void addBid(Bid bid) {
		bids.add(bid);
	}

	@Override
	public List<Category> findAllCategory() {
		return categories.findAll();
	}

	@Override
	public List<Category> findCategoryByName(String name) {
		return categories.findByName(name);
	}

	@Override
	public void addCategory(Category category) {
		categories.add(category);
	}

	@Override
	public List<Item> findAllItem() {
		return items.findAll();
	}

	@Override
	public List<Item> findItemByUser(Users user) {
		return items.findByUser(user);
	}

	@Override
	public List<Item> findItemByCategory(Category category) {
		return items.findByCategory(category);
	}

	@Override
	public List<Item> findItemBySearch(String search) {
		return items.findBySearch(search);
	}

	@Override
	public void addItem(Item item) {
		items.add(item);
	}

	@Override
	public List<UserDetails> findAllUserDetails() {
		return users.findAllDetails();
	}

	@Override
	public UserDetails findUserDetailsByUser(Users user) {
		return users.findDetailsByUser(user);
	}

	@Override
	public void addUserDetails(UserDetails userDetails) {
		users.addDetails(userDetails);
	}

	@Override
	public List<UserRoles> findAllUserRoles() {
		return users.findAllRoles();
	}

	@Override
	public UserRoles findUserRolesByUser(Users user) {
		return users.findRolesByUser(user);
	}

	@Override
	public void addUserRoles(UserRoles userRoles) {
		users.addRoles(userRoles);
	}

	@Override
	public List<Users> findAllUsers() {
		return users.findAll();
	}

	@Override
	public Users findUsersByUserName(String userName) {
		return users.findByUserName(userName);
	}

	@Override
	public void addUsers(Users user) {
		users.add(user);
	}

	@Override
	public void setAuctions(AuctionService auctions) {
		this.auctions = auctions;
	}

	@Override
	public void setBids(BidService bids) {
		this.bids = bids;
	}

	@Override
	public void setCategories(CategoryService categories) {
		this.categories = categories;
	}

	@Override
	public void setItems(ItemService items) {
		this.items = items;
	}

	@Override
	public void setUsers(UserService users) {
		this.users = users;
	}

}
