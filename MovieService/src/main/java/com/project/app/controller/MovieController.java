/**
 * 
 */
package com.project.app.controller;

import javax.annotation.security.RolesAllowed;

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
public class MovieController {

	
	@RolesAllowed("ADMIN")
	@GetMapping("/movies")
	public String getAllMovies() {
		return "Get All Movies"; 
	}
	
	@RolesAllowed("CLIENT")
	@GetMapping("/movie/{id}")
	public String getMovieByID(@PathVariable long id) {
		return "Get Movie By ID "+id; 
	}
	
	
}
