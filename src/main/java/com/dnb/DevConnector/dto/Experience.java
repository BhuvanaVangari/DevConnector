package com.dnb.DevConnector.dto;

import java.time.LocalDate;

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
public class Experience {
	@Id
	@NotBlank(message = "Experience id should not be blank")
	//@GeneratedValue(strategy = GenerationType.UUID)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "experience_seq")
	
	@GenericGenerator(name = "experience_seq", strategy = "com.dnb.DevConnector.utils.CustomIdGenerator",
	parameters =  {@Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value="50"),
			@Parameter(name=CustomIdGenerator.BOOLEAN_FORMAT_PARAMETER,value="true"),
			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER,value="Exp_")}
			)
	private String experienceId;//exp_date_number//https://thorben-janssen.com/custom-sequence-based-idgenerator/
	@Column(nullable = false)
	@NotBlank(message = "jobTitle should not be blank")
	private String jobTitle;
	@Column(nullable = false)
	@NotBlank(message = "Company name should not be blank")
	private String Company;
	private String location;
	private LocalDate fromDate;
	private LocalDate toDate;
}
