package io.trade.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.trade.model.Auction;
import io.trade.model.Item;
import io.trade.model.Users;
import io.trade.repository.ItemRepository;
@Service
public class ItemServiceImpl implements ItemService {

	private final ItemRepository items;
	private final DatabaseService database;

	@Autowired
	public ItemServiceImpl(ItemRepository items, DatabaseService db) {
		this.items = items;
		this.database = db;
		this.database.setItems(this);
	}

	@Override
	public List<Item> findAll() {
		return items.findAll();
	}

	@Override
	public List<Item> findByUser(Users user) {
		List<Auction> auctions = database.findAuctionByUser(user);
		Set<Item> i = new HashSet<Item>();
		for(Auction a:auctions){
			i.add(a.getItem());
		}
		return new ArrayList<Item>(i);
	}

	@Override
	public void add(Item item) {
		items.save(item);
	}

	@Override
	public List<Item> findBySearch(String search) {
		Set<Item> i = new HashSet<Item>(items.findByDescriptionContains(search));
		i.addAll(items.findByNameContains(search));
		return new ArrayList<Item>(i);
	}

}
