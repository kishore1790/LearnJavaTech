package org.poc.LearnJavaTech.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.poc.LearnJavaTech.dao.UserDAO;
import org.poc.LearnJavaTech.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return sessionFactory.openSession().createQuery("from User").list();
	}

}
