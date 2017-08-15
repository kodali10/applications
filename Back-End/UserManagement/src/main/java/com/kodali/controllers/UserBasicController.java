package com.kodali.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.kodali.beans.UserBasic;
import com.kodali.services.UserBasicService;

@RestController
public class UserBasicController {
	@Autowired
	private UserBasicService service;

	public void setService(UserBasicService service) {
		this.service = service;
	}
	@RequestMapping(value = "/api/hello")

	public String greet() {
		return "Hello from the server side!!!";

	}
	@RequestMapping(value = "/user/new", method = RequestMethod.POST)
	public ResponseEntity<Void> addUser(@RequestBody UserBasic user, UriComponentsBuilder ucb) {
		if (service.isUserExist(user)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {

			service.addUserBasic(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucb.path("/user/{id}").buildAndExpand(user.getId()).toUri());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}

	// Get Single user
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserBasic> getuser(@PathVariable("id") int id) {

		UserBasic user = service.findUserById(id);
		if (user == null) {
			return new ResponseEntity<UserBasic>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserBasic>(user, HttpStatus.OK);
	}

	// Get All users
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<UserBasic>> listAllusers() {
		List<UserBasic> users = service.getAllUser();
		if (users.isEmpty()) {
			return new ResponseEntity<List<UserBasic>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserBasic>>(users, HttpStatus.OK);
	}

	// Update user
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserBasic> updateuser(@PathVariable("id") int id, @RequestBody UserBasic cus) {

		UserBasic user = service.findUserById(id);

		if (user == null) {
			return new ResponseEntity<UserBasic>(HttpStatus.NOT_FOUND);
		}

		user.setName(cus.getName());
		user.setAge(cus.getAge());
		user.setEmail(cus.getEmail());

		service.updateUserBasic(user);
		return new ResponseEntity<UserBasic>(user, HttpStatus.OK);
	}

	// Delete user
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserBasic> deleteuser(@PathVariable("id") int id) {

		UserBasic user = service.findUserById(id);
		if (user == null) {
			return new ResponseEntity<UserBasic>(HttpStatus.NOT_FOUND);
		}

		service.deleteUserById(id);
		return new ResponseEntity<UserBasic>(HttpStatus.NO_CONTENT);
	}

	// Delete All users
	@RequestMapping(value = "/user/deleteall", method = RequestMethod.DELETE)
	public ResponseEntity<UserBasic> deleteAllusers() {

		service.deleteAllUsers();
		return new ResponseEntity<UserBasic>(HttpStatus.NO_CONTENT);
	}

}
