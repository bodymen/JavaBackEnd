package com.curso.m16.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.m16.common.UtilHelper;
import com.curso.m16.model.User;

@RestController
public class UsersController {

	@PostMapping("/user")
	private User login(@RequestParam("user") String username, @RequestParam("pwd") String pwd) {
		//Get user from DB
		String token= UtilHelper.getJWToken(username);
		User user = new User();
		user.setUser(username);
		user.setToken(token);
		return user;
	}
}
