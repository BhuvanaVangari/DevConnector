package com.dnb.DevConnector.service;

import java.util.Optional;

import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.exceptions.IdNotFoundException;

public interface ProfileService {
	public Profile createProfile(Profile profile) throws IdNotFoundException;
	
	public Optional<Profile> getProfileById(String profileUUId);
	
	public Iterable<Profile> getAllProfiles();
	
	public boolean deleteProfileById(String profileUUID) throws IdNotFoundException;

	public boolean profileExistsById(String profileId);
}
