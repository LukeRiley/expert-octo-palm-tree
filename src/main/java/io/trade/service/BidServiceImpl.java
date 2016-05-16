package io.trade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.trade.model.Auction;
import io.trade.model.Bid;
import io.trade.model.Users;
import io.trade.repository.BidRepository;
@Service
public class BidServiceImpl implements BidService {
	
	private final BidRepository bids;
	private final DatabaseService database;

	@Autowired
	public BidServiceImpl(BidRepository bids, DatabaseService db) {
		this.bids = bids;
		this.database = db;
		this.database.setBids(this);
	}

	@Override
	public List<Bid> findAll() {
		return bids.findAll();
	}

	@Override
	public List<Bid> findByAuction(Auction auction) {
		return bids.findByAuction(auction);
	}

	@Override
	public List<Bid> findByUser(Users user) {
		return bids.findByUsers(user);
	}

	@Override
	public void add(Bid bid) {
		try{
		bids.save(bid);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
