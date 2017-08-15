package com.kodali.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.kodali.beans.UserBasic;
import com.kodali.dao.UserBasicDao;

public class UserBasicDaoImpl implements UserBasicDao {

	// Session Factory
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// Find user by id
	
	@Override
	public UserBasic findUserById(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		UserBasic user = new UserBasic();
		try {
			user = (UserBasic) session.get(UserBasic.class, id);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
		return user;
	}

	// Find user by name
	
	@Override
	public UserBasic findUserByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		UserBasic user = new UserBasic();
		String hql = "from com.kodali.beans.UserBasic where name = ?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, name);
			user = (UserBasic) query.uniqueResult();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
		return user;
	}

	// Add User
	
	@Override
	public void addUserBasic(UserBasic user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (user != null) {
			try {
				session.save(user);
				transaction.commit();
				session.close();
			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}
		}
	}

	// Update user
	
	@Override
	public void updateUserBasic(UserBasic user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (user != null) {
			try {
				session.update(user);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}

		}

	}

	// delete user by id
	
	@Override
	public void deleteUserById(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		UserBasic user = new UserBasic();
		try {
			user = (UserBasic) session.get(UserBasic.class, id);
			session.delete(user);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
	}

	// find all users
	
	@Override
	@SuppressWarnings("unchecked")
	public List<UserBasic> getAllUser() {
		List<UserBasic> users = new ArrayList<UserBasic>();
		Session session = sessionFactory.openSession();
		users = session.createQuery("From com.kodali.beans.UserBasic").list();
		return users;
	}

	// delete all users
	
	@Override
	public void deleteAllUsers() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.createQuery("delete from UserBasic").executeUpdate();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}

	}

	// find if user exists
	
	@Override
	public boolean isUserExist(UserBasic user) {

		return findUserByName(user.getName()) != null;
	}

}
