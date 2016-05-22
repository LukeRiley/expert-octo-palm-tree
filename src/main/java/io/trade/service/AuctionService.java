package io.trade.service;

import java.util.List;

import io.trade.model.Auction;
import io.trade.model.Category;
import io.trade.model.Item;
import io.trade.model.Users;

public interface AuctionService {

	List<Auction> findAll();

	List<Auction> findByUser(Users user);

	List<Auction> findBySearch(String search);

	void add(Auction auction);

	List<Auction> findByItem(Item item);

	List<Auction> findByCategory(Category category);

	Auction findById(Integer id);

}
