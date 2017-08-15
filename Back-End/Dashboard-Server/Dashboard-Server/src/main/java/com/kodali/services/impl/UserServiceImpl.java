package com.kodali.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kodali.beans.Users;
import com.kodali.dao.UserDao;
import com.kodali.services.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	//setter for userDao
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void addUser(Users user) {
		userDao.addUserBasic(user);
		
	}
	@Override
	public boolean isUserExist(Users user) {
		
		return userDao.isUserExist(user);
	}
	
	@Override
	public Users findUserByName(String name) {
		
		return userDao.findUserByName(name);
	}
}


