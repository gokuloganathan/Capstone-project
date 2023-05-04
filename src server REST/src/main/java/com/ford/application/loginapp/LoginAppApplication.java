package com.ford.application.loginapp;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ford.application.loginapp.Repo.UserRepo;
import com.ford.application.loginapp.modal.User;

@SpringBootApplication
public class LoginAppApplication {

    public static void main(final String[] args) {
        SpringApplication.run(LoginAppApplication.class, args);
    }
    
    @Bean
    CommandLineRunner init(UserRepo userRepo) {
    	/*command line runner used to run code which we want immediately to be run after the spring boot starts*/
        return a -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User(name, name.toLowerCase() + "@domain.com");
                userRepo.save(user);
            });
            userRepo.findAll().forEach(System.out::println);
        };
    }

}
