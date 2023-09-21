package com.dnb.DevConnector.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.DevConnector.dto.Education;
import com.dnb.DevConnector.dto.Experience;
import com.dnb.DevConnector.exceptions.DataNotFoundException;
import com.dnb.DevConnector.exceptions.IdNotFoundException;
import com.dnb.DevConnector.exceptions.InvalidIdException;
import com.dnb.DevConnector.mapper.RequestToEntityMapper;
import com.dnb.DevConnector.payload.request.EducationRequest;
import com.dnb.DevConnector.payload.request.ExperienceRequest;
import com.dnb.DevConnector.service.EducationService;
import com.dnb.DevConnector.service.ExperienceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

	@Autowired
	ExperienceService experienceService;
	
	@Autowired
	RequestToEntityMapper requestToEntityMapper;
	
	@PostMapping("/create")
	public ResponseEntity<?>createExperienceProfile(@Valid @RequestBody ExperienceRequest experienceRequest){
		Experience experience=requestToEntityMapper.getExperienceEntityObject(experienceRequest);
		try {
			Experience experience2 = experienceService.createExperience(experience);
			return new ResponseEntity(experience2,HttpStatus.CREATED);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/exp/{exerienceId}")
	public ResponseEntity<?>getExperienceById(@PathVariable("experienceId")String experienceId) throws InvalidIdException{
		Optional<Experience>optional=experienceService.getExperienceById(experienceId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new InvalidIdException("Experience id is not valid");
		}
	}
	
	@GetMapping("/exp")
	public ResponseEntity<?>getAllExperiences() throws DataNotFoundException{
		List<Experience>experiences=(List<Experience>) experienceService.getAllExperiences();
		if(experiences.isEmpty()) {
			throw new DataNotFoundException("Data not found");
		}
		else {
			return ResponseEntity.ok(experiences);
		}
	}
	
	@DeleteMapping("/{experienceId}")
	public ResponseEntity<?> deleteExperienceById(@PathVariable("experienceId")String experienceId) throws IdNotFoundException, InvalidIdException{
		if(experienceService.experienceExistsById(experienceId)) {
			experienceService.deleteExperienceById(experienceId);
			return ResponseEntity.noContent().build();
		}
		else {
			throw new InvalidIdException("Experience id is not valid");
		}
	}
}
