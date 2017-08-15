package com.kodali.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kodali.beans.UserBasic;
import com.kodali.dao.UserBasicDao;
import com.kodali.services.UserBasicService;

public class UserBasicServiceImpl implements UserBasicService {
	@Autowired
	private UserBasicDao userDao;

	//setter for userDao
	public void setUserDao(UserBasicDao userDao) {
		this.userDao = userDao;
	}
	

	@Override
	public UserBasic findUserById(int id) {
		
		return userDao.findUserById(id);
	}

	@Override
	public UserBasic findUserByName(String name) {
		
		return userDao.findUserByName(name);
	}

	@Override
	public void addUserBasic(UserBasic user) {
		userDao.addUserBasic(user);
		
	}

	@Override
	public void updateUserBasic(UserBasic user) {
		userDao.updateUserBasic(user);
		
	}

	@Override
	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
		
	}

	@Override
	public List<UserBasic> getAllUser() {
		
		return userDao.getAllUser();
	}

	@Override
	public void deleteAllUsers() {
		
		userDao.deleteAllUsers();
	}

	@Override
	public boolean isUserExist(UserBasic user) {
		
		return userDao.isUserExist(user);
	}

}
