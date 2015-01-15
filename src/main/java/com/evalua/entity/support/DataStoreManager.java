package com.evalua.entity.support;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DataStoreManager {

	private SessionFactory sessionFactory;	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(EntityBase entity){		
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(entity);
		session.flush();
	}
	
	public void delete(EntityBase entity){		
		Session session=sessionFactory.getCurrentSession();
		session.delete(entity);
		session.flush();
	}

}
