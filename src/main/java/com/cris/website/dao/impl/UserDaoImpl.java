package com.cris.website.dao.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.query.Query;

import com.cris.website.dao.UserDao;
import com.cris.website.model.UserModel;

public class UserDaoImpl extends CrisAbstractDaoImpl implements UserDao {

	@Override
	public UserModel findUserByPhoneNum(String phoneNum) {
		Query<UserModel> query = getSessionFactory().openSession().createQuery("from UserModel where phoneNum = ?");
		query.setParameter(0, phoneNum);
		List<UserModel> result = query.list();
		return CollectionUtils.isNotEmpty(result) ? result.get(0) : null;
	}

}
