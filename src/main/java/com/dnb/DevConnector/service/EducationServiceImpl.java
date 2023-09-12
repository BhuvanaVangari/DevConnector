package com.dnb.DevConnector.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.DevConnector.dto.Education;
import com.dnb.DevConnector.exceptions.IdNotFoundException;
import com.dnb.DevConnector.repo.EducationRepository;

@Service("educationServiceImpl")
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationRepository educationRepository;
	
	@Override
	public Education createEducationProfile(Education education) {
		// TODO Auto-generated method stub
		return educationRepository.save(education);
	}

	@Override
	public Optional<Education> getEducationProfileById(String educationId) {
		// TODO Auto-generated method stub
		return educationRepository.findById(educationId);
	}

	@Override
	public Iterable<Education> getAllEducations() {
		// TODO Auto-generated method stub
		return educationRepository.findAll();
	}

	@Override
	public boolean deleteEducationById(String educationID) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(educationRepository.existsById(educationID)) {
			educationRepository.deleteById(educationID);
			if(educationRepository.existsById(educationID)) {
				return false;
			}
			return true;
		}
		else {
			throw new IdNotFoundException("ID not found");
		}
	}

}
