package com.dnb.DevConnector.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.dto.User;
import com.dnb.DevConnector.exceptions.IdNotFoundException;
import com.dnb.DevConnector.repo.ProfileRepository;
import com.dnb.DevConnector.repo.UserRepository;

@Service("profileServiceImpl")
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Profile createProfile(Profile profile) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<User>user=userRepository.findById(profile.getUser().getUserId());
		
		if(user.isPresent()) {
			profile.setUser(user.get());
			return profileRepository.save(profile);
		}
		else {
			user.orElseThrow(()->new IdNotFoundException("User id is not valid"));
		}
		return null;
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

	@Override
	public boolean profileExistsById(String profileId) {
		if(profileRepository.existsById(profileId))return true;
		else return false;
	}
}
