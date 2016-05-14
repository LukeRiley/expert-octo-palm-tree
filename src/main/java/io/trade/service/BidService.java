package io.trade.service;

import java.util.List;

import io.trade.model.Auction;
import io.trade.model.Bid;
import io.trade.model.Users;

public interface BidService {

	List<Bid> findAll();

	List<Bid> findByAuction(Auction auction);

	List<Bid> findByUser(Users user);

	void add(Bid bid);

}
