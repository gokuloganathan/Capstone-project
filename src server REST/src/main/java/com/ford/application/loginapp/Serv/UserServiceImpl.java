package com.ford.application.loginapp.Serv;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ford.application.loginapp.Repo.UserRepo;
import com.ford.application.loginapp.modal.User;
import com.ford.application.loginapp.modal.UserRequestDTO;
import com.ford.application.loginapp.modal.UserResponseDTO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<UserResponseDTO> getAllUsers() {
		List<User> allUsers = userRepo.findAll();
		//List<UserResponseDTO> userResponseDTOs = allUsers.stream().map((user) -> new UserResponseDTO(user)).collect(Collectors.toList()));
        return (List<UserResponseDTO>)allUsers.stream().map(user -> new UserResponseDTO(user)).collect(Collectors.toList());
	}

	@Override
	public UserResponseDTO getUserById(int id) {
		Optional<User> user = userRepo.findById(id);
		UserResponseDTO userResponseDTO = new UserResponseDTO(user.get());
		return userResponseDTO;
	}

	@Override
	public UserResponseDTO addNewUser(UserRequestDTO userRequestDTO) {
		 User user = new User(userRequestDTO);
		 User newUser = userRepo.save(user); 
		 
		 UserResponseDTO userResponseDTO = new UserResponseDTO(newUser); 
		 return userResponseDTO; 
	}

	@Override
	public UserResponseDTO updateOldUser(int id, UserRequestDTO userRequestDTO) {
		Optional<User> userOptional = userRepo.findById(id);
		User updatedUser = new User(userOptional.get());
		userRepo.flush();

		UserResponseDTO userResponseDTO = new UserResponseDTO(updatedUser);
		return userResponseDTO;

	}

	@Override
	public UserResponseDTO deleteUserById(int id) {
		Optional<User> deleteUser = userRepo.findById(id);
		userRepo.deleteById(id);
    	
		UserResponseDTO userResponseDTO = new UserResponseDTO(deleteUser.get());
    	return userResponseDTO;
	}

	@Override
	public List<UserResponseDTO> deleteAllUsers() {
		List<User> allUsers = userRepo.findAll();
    	userRepo.deleteAll();
    	return (List<UserResponseDTO>)allUsers.stream().map(user -> new UserResponseDTO(user)).collect(Collectors.toList());
	}

}
