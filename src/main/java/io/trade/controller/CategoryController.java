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
public class CategoryController {

	private final DatabaseService database;

	@Autowired
	public CategoryController(DatabaseService db) {
		this.database = db;
	}

	@RequestMapping(value = "/auth/category/all", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> findAll(){
		return new ResponseEntity<List<Category>>(database.findAllCategory(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/auth/category/user", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> findByUser(@RequestBody String name){
		return new ResponseEntity<List<Category>>(database.findCategoryByName(name), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/auth/category/add", method = RequestMethod.POST, consumes = "application/json")
	public void add(@RequestBody Category category){
		database.addCategory(category);
	}
}
