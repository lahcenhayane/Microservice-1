package com.project.app.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lahcen HAYANE <lahcenhayane@gmail.ma>
 * @Date 6 avr. 2022
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@GetMapping("users")
	public String getAllUsers(){
		return "Get All Users";
	}
	
	@GetMapping("profil")
	public String getUserID(Principal principal){
		return "ID :"+principal.getName();
	}
	
	@GetMapping("user/{id}")
	public String getAllUsers(@PathVariable long id){
		return "Get User "+id;
	}

}
