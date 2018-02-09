package com.cris.website.dao.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.query.Query;

import com.cris.website.dao.UserDao;
import com.cris.website.model.User;

public class UserDaoImpl extends CrisAbstractDaoImpl implements UserDao {

	@Override
	public User findUserByPhoneNum(String phoneNum) {
		Query query = getSessionFactory().openSession().createQuery("from User where phoneNum = ?");
		query.setParameter(0, phoneNum);
		List<User> result = query.list();
		return CollectionUtils.isNotEmpty(result) ? result.get(0) : null;
	}

}
