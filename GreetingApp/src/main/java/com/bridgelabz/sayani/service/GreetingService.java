package com.bridgelabz.sayani.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.stereotype.Service;

import com.bridgelabz.sayani.dto.NewGreeting;

@Service
public class GreetingService {
	private static final String template = "Hello, %s %s!";
	private List<NewGreeting> greetingList = new ArrayList<>();
	
	/**
	 * Purpose : To return the String message to the Controller
	 * @return
	 */
	
	public String getMessage() {
		return "Hello World";
	}

	/**
	 * Purpose : To return the String message to the Controller
	 * @param fname
	 * @param lname
	 * @return
	 */
	
	public String getGreeting(String fname, String lname) {
		return String.format(template, fname, lname);
	}

	/**
	 * Purpose : Ability to store multiple messages in greeting object
	 			 and display the list of object to get the messages.
	 * @param greeting
	 * @return
	 */

	public NewGreeting addGreeting(NewGreeting greeting) {
		greetingList.add(greeting);
		return greeting;
	}

	public List<NewGreeting> getGreeting() {
		return greetingList;
	}

	/**
	 * Purpose : Ability to get greeting message by id
	 * @param id
	 * @return
	 */
	
    public String getEmployeeByID(int id) {
		AtomicReference<String> greetings = new AtomicReference<>("");
		greetingList.stream()
				.filter(greetingElement -> greetingElement.getId() == id)
				.forEach(greetingElement -> {
					greetings.set(greetingElement.getMessage());
			});
		return String.valueOf(greetings);
    }
}
