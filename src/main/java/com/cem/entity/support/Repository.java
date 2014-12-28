package com.cem.entity.support;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cem.entity.User;

public class Repository {
	
	private SessionFactory sessionFactory;	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private Session getSession(){		
		return sessionFactory.getCurrentSession();
	}
	
	public User findUserByEmail(String email){
		
		Query query=getSession().createQuery("FROM "+User.class.getName()+" where email=:email");
		query.setParameter("email", email);
		return (User) query.uniqueResult();		
	}
}
