package com.cg.addressbook.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class AddressBookDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}[ ][A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid FullName")
	public String fullName;
	@Pattern(regexp = "^[A-Za-z0-9-,\\.]{2,}([\\s][A-Za-z0-9-,\\.]{3,}){0,}$", message = "Invalid Address")
	public String address;
	@NotBlank(message = "City cannot be Empty")
	public String city;
	@NotBlank(message = "State cannot be Empty")
	public String state;
	@Pattern(regexp ="^[1-9]{1}[0-9]{5}$", message = "Invalid Zip Code")
	public String zip;
	@Pattern(regexp = "^[1-9]{1}[0-9]{9}$", message = "Invalid Phone Number")
	public String phoneNumber;
}