package com.dnb.DevConnector.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.DevConnector.dto.Profile;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

	@PostMapping("/create")
	public Profile createProfile(@RequestBody Profile profile) {
		return profile;
	}
}
