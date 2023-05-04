package com.ford.application.loginapp.API;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ford.application.loginapp.Repo.UserRepo;
import com.ford.application.loginapp.Serv.UserService;
import com.ford.application.loginapp.modal.User;
import com.ford.application.loginapp.modal.UserRequestDTO;
import com.ford.application.loginapp.modal.UserResponseDTO;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserAPI {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping
    public List<UserResponseDTO> getUsers() {
        return userService.getAllUsers();
    }
	
	@GetMapping("/{id}")
	public UserResponseDTO getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	/*
	 * @PutMapping("/{id}") 
	 * public UserResponseDTO updateUserById(@PathVariable int id,@RequestBody UserRequestDTO userRequestDTO) { 
	 * return userService.updateOldUser(id, userRequestDTO); 
	 * }
	 * 
	 * @PostMapping 
	 * public UserResponseDTO addUser(@RequestBody UserRequestDTO userRequestDTO) { 
	 * return userService.addNewUser(userRequestDTO); 
	 * }
	 */
	
	@PutMapping("/{id}")
	public UserResponseDTO updateUserById(@PathVariable int id,@RequestBody User user) {
		UserRequestDTO userRequestDTO = new UserRequestDTO(user);
		return userService.updateOldUser(id,userRequestDTO);
		
		/*
		 * Optional<User> userOptional = userRepo.findById(id); User updatedUser = new
		 * User(userOptional.get()); userRepo.flush(); return updatedUser;
		 */
	}

    @PostMapping
    public UserResponseDTO addUser(@RequestBody User user) {
        UserRequestDTO userRequestDTO = new UserRequestDTO(user);
        return userService.addNewUser(userRequestDTO);
    }
    
    @DeleteMapping("/{id}")
    public UserResponseDTO deleteUser(@PathVariable int id) {
    	return userService.deleteUserById(id);
    }
    
    @DeleteMapping
    public List<UserResponseDTO> deleteAllList(){
    	return userService.deleteAllUsers();
    }
}
