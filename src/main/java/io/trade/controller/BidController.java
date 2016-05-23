package io.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.trade.model.*;
import io.trade.service.DatabaseService;

@RestController
public class BidController {

	private final DatabaseService database;

	@Autowired
	public BidController(DatabaseService db) {
		this.database = db;
	}

	@RequestMapping(value = "/auth/bid/all", method = RequestMethod.GET)
	public ResponseEntity<List<Bid>> findAll(){
		return new ResponseEntity<List<Bid>>(database.findAllBid(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/auth/bid/user", method = RequestMethod.GET)
	public ResponseEntity<List<Bid>> findByUser(@RequestBody Users user){
		return new ResponseEntity<List<Bid>>(database.findBidByUser(user), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/auth/bid/item", method = RequestMethod.POST)
	public ResponseEntity<List<Bid>> findByAuction(@RequestBody Auction auction){
		return new ResponseEntity<List<Bid>>(database.findBidByAuction(auction), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/auth/bid/add", method = RequestMethod.GET)
	public void add(@RequestBody Bid bid){
		database.addBid(bid);
	}
}
