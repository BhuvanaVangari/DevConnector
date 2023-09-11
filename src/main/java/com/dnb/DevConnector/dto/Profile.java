package com.dnb.DevConnector.dto;

import java.util.UUID;
import java.util.regex.Pattern;

import com.dnb.DevConnector.exceptions.InvalidSkillsException;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
public class Profile {
	@Id
	private String profileUUID;
	private String professionalStatus;
	private String company;
	private String website;
	private String location;
	private String skills;
	private String gitUsername;
	private String bio;
	private String twitterURL;
	private String facebookURL;
	private String youTubeURL;
	private String linkedinURL;
	private String instagramURL;
	
	public Profile(String professionalStatus, String company, String website, String location,
			String skills, String gitUsername, String bio, String twitterURL, String facebookURL, String youTubeURL,
			String linkedinURL, String instagramURL) throws InvalidSkillsException {
		super();
		this.setProfileUUID();
		this.setProfessionalStatus(professionalStatus);
		this.setCompany(company);
		this.setWebsite(website); 
		this.setLocation(location);
		this.setSkills(skills);
		this.setGitUsername(gitUsername);
		this.setBio(bio); 
		this.setTwitterURL(twitterURL); 
		this.setFacebookURL(facebookURL); 
		this.setYouTubeURL(youTubeURL); 
		this.setLinkedinURL(linkedinURL); 
		this.setInstagramURL(instagramURL); 
	}
	
	public void setProfileUUID() {
		this.profileUUID = UUID.randomUUID().toString();
	}
	public void setProfessionalStatus(String professionalStatus) {
		this.professionalStatus = professionalStatus;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setSkills(String skills) throws InvalidSkillsException {
		String regex="^[a-zA-Z]+(,[a-zA-Z]+)*$";
//				True: hello
//				True: hello,world
//				False: hello,world,
//				False: ,hello
//				False: hello,world,123,
//				False: hello,123,
//				False: hello,
		if(Pattern.compile(regex).matcher(skills).find())
			this.skills = skills;
		else {
			throw new InvalidSkillsException("Give proper commas between skills");
		}
	}
	public void setGitUsername(String gitUsername) {
		this.gitUsername = gitUsername;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public void setTwitterURL(String twitterURL) {
		this.twitterURL = twitterURL;
	}
	public void setFacebookURL(String facebookURL) {
		this.facebookURL = facebookURL;
	}
	public void setYouTubeURL(String youTubeURL) {
		this.youTubeURL = youTubeURL;
	}
	public void setLinkedinURL(String linkedinURL) {
		this.linkedinURL = linkedinURL;
	}
	public void setInstagramURL(String instagramURL) {
		this.instagramURL = instagramURL;
	}
		
}
