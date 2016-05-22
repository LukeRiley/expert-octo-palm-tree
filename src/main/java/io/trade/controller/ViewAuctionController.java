package io.trade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewAuctionController {

	@RequestMapping(value = "/viewAuction")
	public String ViewAuction() {
		
		return "viewAuction";
	}

}
