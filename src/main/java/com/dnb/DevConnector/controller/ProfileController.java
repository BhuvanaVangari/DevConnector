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

import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.exceptions.DataNotFoundException;
import com.dnb.DevConnector.exceptions.IdNotFoundException;
import com.dnb.DevConnector.exceptions.InvalidIdException;
import com.dnb.DevConnector.mapper.RequestToEntityMapper;
import com.dnb.DevConnector.payload.request.ProfileRequest;
import com.dnb.DevConnector.service.ProfileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

	@Autowired
	ProfileService profileService;
	
	@Autowired
	RequestToEntityMapper requestToEntityMapper;
	
	@PostMapping("/create")
	public ResponseEntity<?>createProfile(@Valid @RequestBody ProfileRequest profileRequest){
		Profile profile=requestToEntityMapper.getProfileEntityObject(profileRequest);
		try {
			Profile profile2 = profileService.createProfile(profile);
			return new ResponseEntity(profile2,HttpStatus.CREATED);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/pro/{profileId}")
	public ResponseEntity<?>getProfileById(@PathVariable("profileId")String profileId) throws InvalidIdException{
		Optional<Profile>optional=profileService.getProfileById(profileId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new InvalidIdException("Profile id is not valid");
		}
	}
	
	@GetMapping("/pro")
	public ResponseEntity<?>getAllProfiles() throws DataNotFoundException{
		List<Profile>profiles=(List<Profile>) profileService.getAllProfiles();
		if(profiles.isEmpty()) {
			throw new DataNotFoundException("Data not found");
		}
		else {
			return ResponseEntity.ok(profiles);
		}
	}
	
	@DeleteMapping("/{profileId}")
	public ResponseEntity<?> deleteProfileById(@PathVariable("profileId")String profileId) throws IdNotFoundException, InvalidIdException{
		if(profileService.profileExistsById(profileId)) {
			profileService.deleteProfileById(profileId);
			return ResponseEntity.noContent().build();
		}
		else {
			throw new InvalidIdException("Profile id is not valid");
		}
	}
}
