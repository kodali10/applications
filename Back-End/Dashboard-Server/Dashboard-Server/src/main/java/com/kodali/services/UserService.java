package com.kodali.services;

import com.kodali.beans.Users;
import com.kodali.dao.UserDao;

public interface UserService {
	void setUserDao(UserDao userDao);

	void addUser(Users user);
	
	boolean isUserExist(Users user);
	Users findUserByName(String name);
}
