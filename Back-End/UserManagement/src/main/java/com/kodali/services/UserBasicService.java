package com.kodali.services;

import java.util.List;

import com.kodali.beans.UserBasic;
import com.kodali.dao.UserBasicDao;

public interface UserBasicService {

	void setUserDao(UserBasicDao userDao);

	// Find user by id
	UserBasic findUserById(int id);

	// Find user by name
	UserBasic findUserByName(String name);

	// Add User
	void addUserBasic(UserBasic user);

	// Update user
	void updateUserBasic(UserBasic user);

	// delete user by id
	void deleteUserById(int id);

	// find all users
	List<UserBasic> getAllUser();

	// delete all users
	void deleteAllUsers();

	// find if user exists
	boolean isUserExist(UserBasic user);
}
