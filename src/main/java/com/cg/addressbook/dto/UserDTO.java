package com.cg.addressbook.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserDTO {
    @Pattern( regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",
            message = "First Letter Should Be Capital")
    private String firstName;

    @Pattern( regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",
            message = "First Letter Should Be Capital")
    private String lastName;

    @Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",
            message="Email Is Not Valid")
    @Email(message = "Enter Valid Email")
    @NotEmpty(message = "Email Should Not Be Empty")
    public String email;

    @NotEmpty
    public String password;

    @Pattern(regexp="male|female",
            message="Gender Should Be Male Or Female")
    private String gender;

    @Pattern(regexp="^[7-9]{1}[0-9]{9}$",
            message="Mobile is not in proper format")
    private String mobileNumber;        
}