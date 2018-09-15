package com.ank.noteshelf.input;

import javax.validation.constraints.Size;

import com.ank.noteshelf.validation.annotation.DateMonth;
import com.ank.noteshelf.validation.annotation.Numeric;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileInput {

	@JsonProperty("gender")
	private String gender;
	 
	@JsonProperty("work")
	private String work;
	
	@JsonProperty("contact_number")
	@Numeric
	@Size(min=8, max=10, message="Entered contact number is not valid.")
	private String contactNumber;
	  
	@JsonProperty("birth_date")
	@DateMonth
	private String birthDate;
	 
	@JsonProperty("birth_year")
	@Numeric
	@Size(min=4, max=4, message="Entered Birth year is not valid.")
	private String birthYear;
	
	@JsonProperty("language")
	private String language;

}