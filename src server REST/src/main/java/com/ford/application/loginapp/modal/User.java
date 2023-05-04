package com.ford.application.loginapp.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "User_tb")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    
	public User(String name, String email) {
		this.setName(name);
		this.setEmail(email);
	}

	public User(User user) {
		this.setName(user.getName());
		this.setEmail(user.getEmail());
	}

	public User(UserRequestDTO userRequestDTO) {
		this.setEmail(userRequestDTO.getEmail());
		this.setName(userRequestDTO.getName());
	}
}
