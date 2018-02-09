package com.cris.website.service.impl;

import com.cris.website.dao.UserDao;
import com.cris.website.model.User;
import com.cris.website.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao uerDaoImpl;

	@Override
	public User findUserByPhoneNum(String phoneNum) {
		return uerDaoImpl.findUserByPhoneNum(phoneNum);
	}

	public UserDao getUerDaoImpl() {
		return uerDaoImpl;
	}

	public void setUerDaoImpl(UserDao uerDaoImpl) {
		this.uerDaoImpl = uerDaoImpl;
	}
}
