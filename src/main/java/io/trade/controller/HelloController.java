package io.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.trade.repository.AuctionRepository;

/*
 * This is just a test/mock controller that will not be in the final release
 */
/**
 * @author Luke Riley
 *
 */
@Controller
public class HelloController {
	
	@Autowired
	AuctionRepository auctions;
	
	@RequestMapping(value = "/hello")
	public String home() {
		System.out.println(auctions.findOne(1).getStartDate());
		return "hello";
	}

}