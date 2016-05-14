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
public class AuctionController {

	private final DatabaseService database;

	@Autowired
	public AuctionController(DatabaseService db) {
		this.database = db;
	}

	@RequestMapping(value = "/login/auction/all", method = RequestMethod.GET)
	public ResponseEntity<List<Auction>> findAll(){
		return new ResponseEntity<List<Auction>>(database.findAllAuction(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login/auction/user", method = RequestMethod.GET)
	public ResponseEntity<List<Auction>> findByUser(@RequestBody Users user){
		return new ResponseEntity<List<Auction>>(database.findAuctionByUser(user), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login/auction/item", method = RequestMethod.GET)
	public ResponseEntity<List<Auction>> findByItem(@RequestBody Item item){
		return new ResponseEntity<List<Auction>>(database.findAuctionByItem(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login/auction/search", method = RequestMethod.GET)
	public ResponseEntity<List<Auction>> findBySearch(@RequestBody String search){
		return new ResponseEntity<List<Auction>>(database.findAuctionBySearch(search), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login/auction/add", method = RequestMethod.POST, consumes = "application/json")
	public void add(@RequestBody Auction auction){
		database.addAuction(auction);
	}
}
