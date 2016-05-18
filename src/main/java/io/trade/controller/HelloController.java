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
public class HelloController {
	
	@RequestMapping(value = "/hello")
	public String home() {
		return "hello";
	}

}