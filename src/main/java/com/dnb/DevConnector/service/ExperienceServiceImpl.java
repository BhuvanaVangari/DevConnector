package com.dnb.DevConnector.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.DevConnector.dto.Experience;
import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.exceptions.IdNotFoundException;
import com.dnb.DevConnector.repo.ExperienceRepository;
import com.dnb.DevConnector.repo.ProfileRepository;

@Service("experienceServiceImpl")
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	private ExperienceRepository experienceRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public Experience createExperience(Experience experience) throws IdNotFoundException {
		Optional<Profile>profile=profileRepository.findById(experience.getProfile().getProfileUUID());
		
		if(profile.isPresent()) {
			experience.setProfile(profile.get());
			return experienceRepository.save(experience);
		}
		else {
			profile.orElseThrow(()->new IdNotFoundException("Profile id is not valid"));
		}
		return null;
	}

	@Override
	public Optional<Experience> getExperienceById(String experienceId) {
		// TODO Auto-generated method stub
		return experienceRepository.findById(experienceId);
	}

	@Override
	public Iterable<Experience> getAllExperiences() {
		// TODO Auto-generated method stub
		return experienceRepository.findAll();
	}

	@Override
	public boolean deleteExperienceById(String experienceID) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(experienceRepository.existsById(experienceID)) {
			experienceRepository.deleteById(experienceID);
			if(experienceRepository.existsById(experienceID)) {
				return false;
			}
			return true;
		}
		else {
			throw new IdNotFoundException("ID Not found");
		}
	}
	
	@Override
	public boolean experienceExistsById(String experienceId) {
		if(experienceRepository.existsById(experienceId))return true;
		else return false;
	}

}
