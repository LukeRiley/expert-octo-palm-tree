package io.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.trade.service.DatabaseService;

@Controller
public class AuctionController {

	private final DatabaseService database;

	@Autowired
	public AuctionController(DatabaseService db) {
		this.database = db;
	}

}
