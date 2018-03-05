package com.cris.website.dao.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cris.website.dao.UserDao;
import com.cris.website.model.UserGroupModel;
import com.cris.website.model.UserModel;

public class UserDaoImpl extends CrisAbstractDaoImpl implements UserDao {

	@Override
	public UserModel findUserByPhoneNum(String phoneNum) {
		Session session = getSessionFactory().openSession();
		Query<UserModel> query = session.createQuery("from UserModel where phoneNum = ?");
		query.setParameter(0, phoneNum);
		List<UserModel> result = query.list();
		session.close();
		return CollectionUtils.isNotEmpty(result) ? result.get(0) : null;
	}

	@Override
	public UserGroupModel findUserGroupByGroupName(String userGroupName) {
		Session session = getSessionFactory().openSession();
		Query<UserGroupModel> query = session.createQuery("from UserGroupModel where groupName = ?");
		query.setParameter(0, userGroupName);
		List<UserGroupModel> result = query.list();
		session.close();
		return CollectionUtils.isNotEmpty(result) ? result.get(0) : null;
	}

}
