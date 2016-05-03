package io.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.trade.model.Users;
import io.trade.model.UserRoles;
import io.trade.repository.UserRepository;
import io.trade.repository.UserRoleRepository;


/*
 * This is just a test/mock controller that will not be in the final release
 */
/**
 * @author Luke Riley
 *
 */
@Controller
public class IndexController {
	
	@Autowired
	UserRepository users;
	
	@Autowired
	UserRoleRepository userRoles;
	
	@RequestMapping(value = "/home")
	public String index() {
		Users u = new Users("admin", "admin", 1);
		UserRoles ur = new UserRoles(u, "ROLE_ADMIN");
		users.save(u);
		userRoles.save(ur);
		u = new Users("user", "user", 1);
		ur = new UserRoles(u, "ROLE_USER");
		users.save(u);
		userRoles.save(ur);
		return "home";
	}

}