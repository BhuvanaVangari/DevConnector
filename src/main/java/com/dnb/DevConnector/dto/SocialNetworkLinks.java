package com.dnb.DevConnector.dto;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class SocialNetworkLinks {
	private String twitterURL;
	private String facebookURL;
	private String youTubeURL;
	private String linkedinURL;
	private String instagramURL;
}
