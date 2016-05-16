package io.trade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateAuctionController {

	@RequestMapping(value = "/createAuction")
	public String register() {
		
		return "createAuction";
	}

}
