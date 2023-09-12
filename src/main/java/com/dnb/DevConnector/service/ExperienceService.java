package com.dnb.DevConnector.service;

import java.util.Optional;

import com.dnb.DevConnector.dto.Experience;
import com.dnb.DevConnector.exceptions.IdNotFoundException;

public interface ExperienceService {
	public Experience createExperience(Experience experience);
	
	public Optional<Experience> getExperienceById(String experienceId);
	
	public Iterable<Experience> getAllExperiences();
	
	public boolean deleteExperienceById(String experienceID) throws IdNotFoundException;
}
