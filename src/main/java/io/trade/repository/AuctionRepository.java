package io.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.trade.model.Auction;

@Repository
public interface AuctionRepository extends CrudRepository<Auction, Integer> {
	
	List<Auction> findAll();
	
}

