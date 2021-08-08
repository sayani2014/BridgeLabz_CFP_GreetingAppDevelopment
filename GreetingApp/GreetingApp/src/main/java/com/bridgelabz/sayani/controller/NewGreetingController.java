/**
 * UC3 : Ability for the Greeting App to give Greeting message with
			1. User First Name and Last Name or
			2. With just First Name or Last Name based on User attributes provides or
			3. Just Hello World.
 * 
 * @author SAYANI KOLEY
 * @since 08.08.2021
 */

package com.bridgelabz.sayani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	 * Execution URL : http://localhost:8080/getMessage
	 */
	
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
	 * Execution URL : 
	 * 1. http://localhost:8080/getGreetingMessage
	 * 2. http://localhost:8080/getGreetingMessage?fname=Sayani
	 * 3. http://localhost:8080/getGreetingMessage?fname=Sayani&lname=Koley
	 */

}
