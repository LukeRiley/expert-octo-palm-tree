package io.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.trade.model.*;

@Repository
public interface AuctionRepository extends CrudRepository<Auction, Integer> {
	
	List<Auction> findAll();
	List<Auction> findByUsers(Users user);
	List<Auction> findByItem(Item item);
}

