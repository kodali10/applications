package com.kodali.dao;

import org.hibernate.SessionFactory;

import com.kodali.beans.Users;

public interface UserDao {
	void setSessionFactory(SessionFactory sessionFactory);
	void addUserBasic(Users user);
	boolean isUserExist(Users user);
	Users findUserByName(String name);
}
