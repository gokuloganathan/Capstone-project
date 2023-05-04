package com.ford.application.loginapp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ford.application.loginapp.modal.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
