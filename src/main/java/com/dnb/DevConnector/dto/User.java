package com.dnb.DevConnector.dto;

import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import com.dnb.DevConnector.exceptions.InvalidEmailIdException;
import com.dnb.DevConnector.exceptions.InvalidPasswordException;

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
public class User {
	
	private String name;
	@Id
	private String emailId;
	private String password;

	public User(String name,String emailId,String password) throws InvalidNameException, InvalidEmailIdException, InvalidPasswordException {
		super();
		this.setName(name);
		this.setEmailId(emailId);
		this.setPassword(password);
	}
	
	public void setName(String name) throws InvalidNameException {
		String regex = "^[a-zA-Z]{2,}$";

		if (Pattern.compile(regex).matcher(name).find())
			this.name = name;
		else
			throw new InvalidNameException("Name is not valid");
	}
	public void setEmailId(String emailId) throws InvalidEmailIdException {
		String regex="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		
		if(Pattern.compile(regex).matcher(emailId).find())
			this.emailId = emailId;
		else
			throw new InvalidEmailIdException("Invalid Mail");
	}
	public void setPassword(String password) throws InvalidPasswordException {
		String regex="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		
		if(Pattern.compile(regex).matcher(password).find())
			this.password = password;
		else
			throw new InvalidPasswordException("Invalid Password:Length should be>12, should contain >1 UPPERCASE Letter, should contain spl chars");
	}
}
