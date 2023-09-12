package com.dnb.DevConnector.service;

import java.util.Optional;

import com.dnb.DevConnector.dto.Education;
import com.dnb.DevConnector.exceptions.IdNotFoundException;

public interface EducationService {
	public Education createEducationProfile(Education education);
	
	public Optional<Education> getEducationProfileById(String educationId);
	
	public Iterable<Education> getAllEducations();
	
	public boolean deleteEducationById(String educationID) throws IdNotFoundException;
}
