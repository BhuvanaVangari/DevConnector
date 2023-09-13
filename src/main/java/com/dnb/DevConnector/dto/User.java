package com.dnb.DevConnector.dto;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.DevConnector.utils.CustomIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
public class User {
	
	
	@Id
	@NotBlank(message = "User id should not be blank")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
	
	@GenericGenerator(name = "user_seq", strategy = "com.dnb.DevConnector.utils.CustomIdGenerator",
	parameters =  {@Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value="50"),
			@Parameter(name=CustomIdGenerator.FLAG_PARAMETER,value="false"),
			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER,value="User_"),
			@Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")}
			)
	private String userId;
	private String name;
	//unique key constraint
	private String emailId;
	private String password;

}
