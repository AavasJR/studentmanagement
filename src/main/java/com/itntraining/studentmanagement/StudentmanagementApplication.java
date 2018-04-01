package com.itntraining.studentmanagement;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@SpringBootApplication
public class StudentmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementApplication.class, args);
	}
	 @Autowired
     public void authenticationManager(AuthenticationManagerBuilder builder, //refractor rename to rename all
    		 UserRepository userRepository) throws Exception{
         System.out.println("hello ");
         if(userRepository.count()==0){	//kati ota user cha hercha .count() le User table ma repo.user le
        	 List<Role> roles =  Arrays.asList(new Role("USER"),new Role("Actuator"));
        	 userRepository.save(new User( "admin", "admin", roles));
            System.out.println("saved");
        }
         builder.userDetailsService((username)-> {
             return new CustomUserDetailsService(userRepository.findByUsername(username));	//userdetails ko object banauna na milera userdetailsservice ko obj banako ho
         }
         );
	 }
}
