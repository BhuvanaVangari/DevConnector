package com.dnb.DevConnector.payload.response;

import lombok.Data;

@Data
public class CreateProfileResponse {
	private String twitterURL;
	private String facebookURL;
	private String youTubeURL;
	private String linkedinURL;
	private String instagramURL;
}
