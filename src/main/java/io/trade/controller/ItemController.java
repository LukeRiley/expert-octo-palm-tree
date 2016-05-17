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
import io.trade.model.Users;
import io.trade.service.DatabaseService;

@RestController
public class ItemController {

	private final DatabaseService database;

	@Autowired
	public ItemController(DatabaseService db) {
		this.database = db;
	}

	@RequestMapping(value = "/auth/item/all", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> findAll(){
		return new ResponseEntity<List<Item>>(database.findAllItem(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/auth/item/user", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> findByUser(@RequestBody Users user){
		return new ResponseEntity<List<Item>>(database.findItemByUser(user), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/auth/item/search", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> findBySearch(@RequestBody String search){
		return new ResponseEntity<List<Item>>(database.findItemBySearch(search), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/auth/item/add", method = RequestMethod.POST, consumes = "application/json")
	public Item add(@RequestBody Item item){
		try{
		database.addItem(item);
		} catch (Exception e){
			e.printStackTrace();
		}
		return item;
	}

}
