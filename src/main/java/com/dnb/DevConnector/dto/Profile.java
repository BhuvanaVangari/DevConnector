package com.dnb.DevConnector.dto;

import java.util.UUID;
import java.util.regex.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.DevConnector.utils.CustomIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
public class Profile {
	@Id
	@NotBlank(message = "profile id should not be blank")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "profile_seq")
	
	@GenericGenerator(name = "profile_seq", strategy = "com.dnb.DevConnector.utils.CustomIdGenerator",
	parameters =  {@Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value="50"),
			@Parameter(name=CustomIdGenerator.FLAG_PARAMETER,value="false"),
			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER,value="Pro_"),
			@Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")}
			)
	private String profileUUID;
	@Column(nullable = false)
	@NotBlank(message = "Professional status should not be blank")
	private String professionalStatus;//not null
	private String company;
	private String website;
	private String location;
	@Column(nullable = false)
	@NotBlank(message = "Skills should not be blank")
	private String skills;//not null
	private String gitUsername;
	private String bio;
	private String twitterURL;
	private String facebookURL;
	private String youTubeURL;
	private String linkedinURL;
	private String instagramURL;
	
		
}
