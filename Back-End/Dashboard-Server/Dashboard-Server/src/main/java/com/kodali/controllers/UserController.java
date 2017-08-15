package com.kodali.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.kodali.beans.Users;
import com.kodali.services.UserService;
@RestController
public class UserController {
	@Autowired
	private UserService service;

	public void setService(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/user/new", method = RequestMethod.POST)
	public ResponseEntity<Void> addUser(@RequestBody Users user, UriComponentsBuilder ucb) {
		if (service.isUserExist(user)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {

			service.addUser(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucb.path("/user/{id}").buildAndExpand(user.getId()).toUri());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
}
