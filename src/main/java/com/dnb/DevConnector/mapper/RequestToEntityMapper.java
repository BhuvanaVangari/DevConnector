package com.dnb.DevConnector.mapper;

import org.springframework.stereotype.Component;

import com.dnb.DevConnector.dto.Education;
import com.dnb.DevConnector.dto.Experience;
import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.dto.User;
import com.dnb.DevConnector.payload.request.EducationRequest;
import com.dnb.DevConnector.payload.request.ExperienceRequest;
import com.dnb.DevConnector.payload.request.ProfileRequest;
import com.dnb.DevConnector.payload.request.UserRequest;

@Component
public class RequestToEntityMapper {
	
	public Education getEducationEntityObject(EducationRequest educationRequest) {
		Education education=new Education();
		education.setSchool(educationRequest.getSchool());
		education.setDegree(educationRequest.getDegree());
		education.setFieldOfStudy(educationRequest.getFieldOfStudy());
		education.setFromDate(educationRequest.getFromDate());
		education.setCurrentSchool(educationRequest.getCurrentSchool());
		education.setToDate(educationRequest.getToDate());
		education.setProgDescription(educationRequest.getProgDescription());
		
		Profile profile=new Profile();
		profile.setProfileUUID(educationRequest.getProfileUUID());
		education.setProfile(profile);
		
		return education;
	}
	
	public Experience getExperienceEntityObject(ExperienceRequest experienceRequest) {
		Experience experience=new Experience();
		experience.setJobTitle(experienceRequest.getJobTitle());
		experience.setCompany(experienceRequest.getCompany());
		experience.setLocation(experienceRequest.getLocation());
		experience.setFromDate(experienceRequest.getFromDate());
		experience.setCurrentJob(experienceRequest.getCurrentJob());
		experience.setToDate(experienceRequest.getToDate());
		experience.setJobDescription(experienceRequest.getJobDescription());
		
		Profile profile=new Profile();
		profile.setProfileUUID(experienceRequest.getProfileUUID());
		experience.setProfile(profile);
		
		return experience;
	}
	
	public Profile getProfileEntityObject(ProfileRequest profileRequest) {
		Profile profile=new Profile();
		profile.setProfessionalStatus(profileRequest.getProfessionalStatus());
		profile.setCompany(profileRequest.getCompany());
		profile.setWebsite(profileRequest.getWebsite());
		profile.setLocation(profileRequest.getLocation());
		profile.setSkills(profileRequest.getSkills());
		profile.setGitUsername(profileRequest.getGitUsername());
		profile.setBio(profileRequest.getBio());
		profile.setLinks(profileRequest.getLinks());
//		profile.setTwitterURL(profileRequest.getTwitterURL());
//		profile.setFacebookURL(profileRequest.getFacebookURL());
//		profile.setYouTubeURL(profileRequest.getYouTubeURL());
//		profile.setLinkedinURL(profileRequest.getLinkedinURL());
//		profile.setInstagramURL(profileRequest.getInstagramURL());
		
		User user=new User();
		user.setUserId(profileRequest.getUserId());
		profile.setUser(user);
		
		return profile;
	}
	
	public User getUserEntityObject(UserRequest userRequest) {
		User user= new User();
		user.setName(userRequest.getName());
		user.setEmailId(userRequest.getEmailId());
		user.setPassword(userRequest.getPassword());
		user.setConfirmPassword(userRequest.getConfirmPassword());
		return user;
	}
	
}