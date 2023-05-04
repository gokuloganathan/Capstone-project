package com.ford.application.loginapp.modal;

import lombok.Data;

@Data
public class UserRequestDTO {
    public UserRequestDTO(User user) {
		setName(user.getName());
		setEmail(user.getEmail());
	}
	private String name;
    private String email;
    
    
}
