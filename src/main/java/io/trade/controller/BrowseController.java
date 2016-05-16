package io.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BrowseController {
	
	@RequestMapping(value = "/browse")
	public String browse() {
		return "browse";
	}
	
}
