package io.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.trade.model.*;

@Repository
public interface BidRepository extends CrudRepository<Bid, Integer> {
	
	List<Bid> findAll();
	List<Bid> findByAuction(Auction auction);
	List<Bid> findByUsers(Users user);
}

