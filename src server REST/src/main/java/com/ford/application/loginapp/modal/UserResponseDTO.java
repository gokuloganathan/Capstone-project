package com.ford.application.loginapp.modal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserResponseDTO {
	private int id;
    private String name;
    private String email;
    
    public UserResponseDTO(User user) {
		this.setId(user.getId());
		this.setName(user.getName());
		this.setEmail(user.getEmail());
	}

}
