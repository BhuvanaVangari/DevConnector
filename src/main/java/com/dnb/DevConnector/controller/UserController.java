package com.dnb.DevConnector.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.DevConnector.dto.User;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return user;
	}
}
