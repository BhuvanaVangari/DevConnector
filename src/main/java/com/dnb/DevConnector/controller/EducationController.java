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
import com.dnb.DevConnector.exceptions.DataNotFoundException;
import com.dnb.DevConnector.exceptions.IdNotFoundException;
import com.dnb.DevConnector.exceptions.InvalidIdException;
import com.dnb.DevConnector.mapper.RequestToEntityMapper;
import com.dnb.DevConnector.payload.request.EducationRequest;
import com.dnb.DevConnector.service.EducationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/education")
public class EducationController {
	
	@Autowired
	EducationService educationService;
	
	@Autowired
	RequestToEntityMapper requestToEntityMapper;
	
	@PostMapping("/create")
	public ResponseEntity<?>createEducationProfile(@Valid @RequestBody EducationRequest educationRequest){
		Education education=requestToEntityMapper.getEducationEntityObject(educationRequest);
		try {
			Education education2 = educationService.createEducationProfile(education);
			return new ResponseEntity(education2,HttpStatus.CREATED);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/edu/{educationId}")
	public ResponseEntity<?>getEducationProfileById(@PathVariable("educationId")String educationId) throws InvalidIdException{
		Optional<Education>optional=educationService.getEducationProfileById(educationId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new InvalidIdException("Education id is not valid");
		}
	}
	
	@GetMapping("/edu")
	public ResponseEntity<?>getAllEducations() throws DataNotFoundException{
		List<Education>educations=(List<Education>) educationService.getAllEducations();
		if(educations.isEmpty()) {
			throw new DataNotFoundException("Data not found");
		}
		else {
			return ResponseEntity.ok(educations);
		}
	}
	
	@DeleteMapping("/{educationId}")
	public ResponseEntity<?> deleteEducationById(@PathVariable("educationId")String educationId) throws IdNotFoundException, InvalidIdException{
		if(educationService.educationExistsById(educationId)) {
			educationService.deleteEducationById(educationId);
			return ResponseEntity.noContent().build();
		}
		else {
			throw new InvalidIdException("Education id is not valid");
		}
	}
}
