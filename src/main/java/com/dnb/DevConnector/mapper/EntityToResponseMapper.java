package com.dnb.DevConnector.mapper;

import org.springframework.stereotype.Component;

import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.payload.response.ProfileResponse;
import com.dnb.DevConnector.utils.Converter;

@Component
public class EntityToResponseMapper {

	
	Converter converter=new Converter();
	
	public ProfileResponse setProfileResponseObject(Profile profile) {
		ProfileResponse profileResponse=new ProfileResponse();
		profileResponse.setProfessionalStatus(profile.getProfessionalStatus());
		profileResponse.setCompany(profile.getCompany());
		profileResponse.setWebsite(profile.getWebsite());
		profileResponse.setLocation(profile.getLocation());
		profileResponse.setSkills(converter.stringToArray(profile.getSkills()));
		profileResponse.setGitUsername(profile.getGitUsername());
		profileResponse.setBio(profile.getBio());
		profileResponse.setLinks(profile.getLinks());
		profileResponse.setUserId(profile.getUser().getUserId());
		return profileResponse;
	}
}
