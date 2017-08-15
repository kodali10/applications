package com.kodali.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.kodali.beans.Users;
import com.kodali.dao.UserDao;

public class UserDaoImpl implements UserDao {
	// Session Factory
		@Autowired
		private SessionFactory sessionFactory;

		
		@Override
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
		
		@Override
		public void addUserBasic(Users user) {
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
		
		@Override
		public boolean isUserExist(Users user) {

			return findUserByName(user.getName()) != null;
		}

		@Override
		public Users findUserByName(String name) {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Users user = new Users();
			String hql = "from com.kodali.beans.Users where name = ?";
			try {
				Query query = session.createQuery(hql);
				query.setParameter(0, name);
				user = (Users) query.uniqueResult();
				transaction.commit();
				session.close();
			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}
			return user;
		}
}
