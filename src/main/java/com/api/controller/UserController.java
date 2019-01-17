package com.api.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.api.model.*;
import com.api.service.user.UserServiceIm;

@RestController
@RequestMapping("users") // /users/
public class UserController {
	Map<String, User> users;
	
	@Autowired
	UserServiceIm userService = new UserServiceIm();
	
	@GetMapping
	public String getUsers(@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="limit", defaultValue="25") int limit,
			@RequestParam(value="sort", defaultValue="desc", required=false) int sort
		) {
		
		return "Get user Method - page: " +page+ ", Limit: "+ limit;
	}
	
	@GetMapping(path="/{userId}", produces = { 
									MediaType.APPLICATION_XML_VALUE,
									MediaType.APPLICATION_JSON_VALUE
								  })
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		//String name = null;
		//int nLength = name.length();
		
		if(users.containsKey(userId)) {
			return new ResponseEntity<User>(users.get(userId), HttpStatus.OK);
		}else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PostMapping(consumes = { 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
		  }, produces = { 
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
				  })
	public ResponseEntity<User> createUser(@Valid @RequestBody UserRequestModel userReq) {
		
		
		User user = userService .createUser(userReq);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PutMapping(path="/{userId}", consumes = { 
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
		  }, produces = { 
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
				  })
	public ResponseEntity<User> updateUsers(@PathVariable String userId, @Valid @RequestBody UpdateUserRequestModel userReq) {
		User userStored = users.get(userId);
		
		userStored.setEmail(userReq.getEmail());
		userStored.setName(userReq.getName());
		
		users.put(userId, userStored);
		
		return new ResponseEntity<User>(userStored, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable String userId) {
		if(users.containsKey(userId)) {
			users.remove(userId);
			return new ResponseEntity<User>(HttpStatus.OK);
		}
		return ResponseEntity.noContent().build();
	}
}
