package com.cris.website.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.FactoryBean;

import com.cris.website.dao.CrisAbstractDao;

public class CrisAbstractDaoImpl implements CrisAbstractDao {

	private FactoryBean<SessionFactory> sessionFactory;

	@Override
	public void saveModel(Object ob) throws Exception {
		SessionFactory factory;
		factory = sessionFactory.getObject();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.persist(ob);
		t.commit();
		session.close();
	}

	public FactoryBean<SessionFactory> getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(FactoryBean<SessionFactory> sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
