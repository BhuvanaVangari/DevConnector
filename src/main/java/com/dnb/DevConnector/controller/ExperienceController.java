package com.dnb.DevConnector.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.DevConnector.dto.Experience;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

	@PostMapping("/create")
	public Experience createExperience(@RequestBody Experience experience) {
		return experience;
	}
}
