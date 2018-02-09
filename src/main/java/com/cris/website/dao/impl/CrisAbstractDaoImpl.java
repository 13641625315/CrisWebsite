package com.cris.website.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cris.website.dao.CrisAbstractDao;

public class CrisAbstractDaoImpl implements CrisAbstractDao {

	private SessionFactory sessionFactory;

	@Override
	public void saveModel(Object ob) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.persist(ob);
		t.commit();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
