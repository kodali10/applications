package com.kodali.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.kodali.beans.UserBasic;

public interface UserBasicDao {

	void setSessionFactory(SessionFactory sessionFactory);

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