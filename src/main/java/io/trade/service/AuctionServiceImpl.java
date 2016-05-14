package io.trade.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.trade.model.Auction;
import io.trade.model.Item;
import io.trade.model.Users;
import io.trade.repository.AuctionRepository;
@Service
public class AuctionServiceImpl implements AuctionService {
	
	private final AuctionRepository auctions;
	private final DatabaseService database;

	@Autowired
	public AuctionServiceImpl(AuctionRepository auctions, DatabaseService db) {
		this.auctions = auctions;
		this.database = db;
		this.database.setAuctions(this);
	}

	@Override
	public List<Auction> findAll() {
		return auctions.findAll();
	}

	@Override
	public List<Auction> findByUser(Users user) {
		return auctions.findByUsers(user);
	}

	@Override
	public List<Auction> findBySearch(String search) {
		List<Item> items = database.findItemBySearch(search);
		List<Auction> a = new ArrayList<Auction>();
		for(Item i: items){
			a.addAll(auctions.findByItem(i));
		}
		return a;
	}

	@Override
	public void add(Auction auction) {
		auctions.save(auction);
	}

	@Override
	public List<Auction> findByItem(Item item) {
		return auctions.findByItem(item);
	}

}
