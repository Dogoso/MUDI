package com.doglab.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.doglab.mvc.mudi.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequestDTO {

	@NotBlank @Size(min = 7)
	private String username;
	@NotBlank @Size(min = 7)
	private String password;
	@NotBlank @Size(min = 7)
	private String repeatedPassword;
	
	@Override
	public String toString() {
		return String.format("Username: %s + Password: %s + RepeatedPassword: %s", 
				username, password, repeatedPassword);
	}
	
	public User toUser() {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEnabled(true);
		return user;
	}
	
}
