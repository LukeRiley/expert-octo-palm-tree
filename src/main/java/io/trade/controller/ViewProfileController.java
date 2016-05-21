package io.trade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewProfileController {

	@RequestMapping(value = "/viewProfile")
	public String ViewProfile() {
		
		return "viewProfile";
	}

}
