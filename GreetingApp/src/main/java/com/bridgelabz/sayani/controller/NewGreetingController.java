/**
 * UC4 : Ability for the Greeting App to save the Greeting Message in the Repository
 * 
 * @author SAYANI KOLEY
 * @since 08.08.2021
 */

package com.bridgelabz.sayani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.sayani.dto.NewGreeting;
import com.bridgelabz.sayani.service.GreetingService;

@RestController
public class NewGreetingController {
	
	/**
	 * Purpose : initialising and creating object for GreetingService.class
	 */
	
	@Autowired
	private GreetingService greetingService;
	
	/**
	 * Purpose : Ability to return message using GET method from the service class
	 * @return
	 */
	
	@GetMapping(value = "/getMessage")
	public ResponseEntity<String> getMessage() {
	    return new ResponseEntity<>(greetingService.getMessage(), HttpStatus.OK);
	}

	/**
	 * Purpose : Ability to return message using GET method from the service class
	 * @param fname
	 * @param lname
	 * @return
	 */
	
	@GetMapping(value = "/getGreetingMessage")
	public ResponseEntity<String> greeting(@RequestParam(value = "fname", defaultValue = "World") String fname,
			@RequestParam(value = "lname", defaultValue = "") String lname) {
		return new ResponseEntity<>(greetingService.getGreeting(fname, lname), HttpStatus.OK);
	}

	/**
	 * Purpose : Ability to store multiple Greeting Message using POST method
	 			 and display the messages using GET method
	 * @return
	 */

	@GetMapping(value = "/getGreetingDetails")
	public ResponseEntity<List<NewGreeting>> getGreeting() {
	    return new ResponseEntity<>(greetingService.getGreeting(), HttpStatus.OK);
	}

	@PostMapping(value = "/addGreetingDetails")
	public ResponseEntity<NewGreeting> addGreeting(@RequestBody NewGreeting greeting) {
	    return new ResponseEntity<>(greetingService.addGreeting(greeting), HttpStatus.OK);
	}
}
