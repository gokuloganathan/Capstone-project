package com.ford.application.loginapp.Serv;

import java.util.List;

import com.ford.application.loginapp.modal.UserRequestDTO;
import com.ford.application.loginapp.modal.UserResponseDTO;

public interface UserService {
	List<UserResponseDTO> getAllUsers();
	
	UserResponseDTO getUserById(int id);
	
	UserResponseDTO addNewUser(UserRequestDTO userRequestDTO);
	
	UserResponseDTO updateOldUser(int id,UserRequestDTO userRequestDTO);
	
	UserResponseDTO deleteUserById(int id);
	
	List<UserResponseDTO> deleteAllUsers();
}
