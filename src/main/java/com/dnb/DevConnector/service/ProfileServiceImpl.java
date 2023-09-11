package com.dnb.DevConnector.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.exceptions.IdNotFoundException;
import com.dnb.DevConnector.repo.ProfileRepository;

@Service("profileServiceImpl")
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public Profile createProfile(Profile profile) {
		// TODO Auto-generated method stub
		return profileRepository.save(profile);
	}

	@Override
	public Optional<Profile> getProfileById(String profileUUId) {
		// TODO Auto-generated method stub
		return profileRepository.findById(profileUUId);
	}

	@Override
	public Iterable<Profile> getAllProfiles() {
		// TODO Auto-generated method stub
		return profileRepository.findAll();
	}

	@Override
	public boolean deleteProfileById(String profileUUID) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(profileRepository.existsById(profileUUID)) {
			profileRepository.deleteById(profileUUID);
			if(profileRepository.existsById(profileUUID)) {
				return false;
			}
			return true;
		}
		else {
			throw new IdNotFoundException("ID Not found");
		}
	}

}
