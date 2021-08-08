/**
 * UC8 : Ability for the Greeting App to delete a Greeting Messages in the Repository.
 *
 * @author SAYANI KOLEY
 * @since 08.08.2021
 */

package com.bridgelabz.sayani.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	 * Purpose : Ability to display the messages using GET method
	 * @return
	 */

	@GetMapping(value = "/getGreetingDetails")
	public ResponseEntity<List<NewGreeting>> getGreeting() {
	    return new ResponseEntity<>(greetingService.getGreeting(), HttpStatus.OK);
	}

    /**
     * Purpose : Ability to store multiple Greeting Message using POST method
     * @param greeting
     * @return
     */

	@PostMapping(value = "/addGreetingDetails")
	public ResponseEntity<NewGreeting> addGreeting(@RequestBody NewGreeting greeting) {
	    return new ResponseEntity<>(greetingService.addGreeting(greeting), HttpStatus.OK);
	}

	/**
	 * Purpose : Ability to get greeting message by id
	 * @param id
	 * @return
	 */

	@GetMapping(value = "/getGreetingByID")
	public ResponseEntity<String> getEmployeeByID(@RequestParam(name = "id") int id) {
		return new ResponseEntity<>(greetingService.getEmployeeByID(id), HttpStatus.OK);
	}

	/**
	 * Purpose : To Edit a Greeting Messages in the Repository.
	 * @param id
	 * @param message
	 * @return
	 */

	@PutMapping(value = "/updateGreeting")
	public ResponseEntity<NewGreeting> updateGreeting(@RequestParam(name = "id") int id,
												   @RequestParam(name = "message") String message) {
		return new ResponseEntity<>(greetingService.updateGreeting(id, message), HttpStatus.OK);
	}

	/**
	 *  Purpose : To Delete a Greeting Messages in the Repository.
	 * @param id
	 * @return
	 */

	@DeleteMapping(value = "/deleteGreeting")
	public ResponseEntity<String> deleteGreeting(@RequestParam(name = "id") int id) {
		return new ResponseEntity<>(greetingService.deleteGreeting(id), HttpStatus.OK);
	}
}
