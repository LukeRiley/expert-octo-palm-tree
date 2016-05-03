package io.trade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * This is just a test/mock controller that will not be in the final release
 */
/**
 * @author Luke Riley
 *
 */
@Controller
public class ErrorController {
	
	@RequestMapping(value = "/403")
	public String accessDenied() {
		
		return "403";
	}

}