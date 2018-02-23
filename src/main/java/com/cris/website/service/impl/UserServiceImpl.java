package com.cris.website.service.impl;

import com.cris.website.dao.UserDao;
import com.cris.website.model.UserModel;
import com.cris.website.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao uerDaoImpl;

	@Override
	public UserModel findUserByPhoneNum(String phoneNum) {
		return uerDaoImpl.findUserByPhoneNum(phoneNum);
	}

	public UserDao getUerDaoImpl() {
		return uerDaoImpl;
	}

	public void setUerDaoImpl(UserDao uerDaoImpl) {
		this.uerDaoImpl = uerDaoImpl;
	}
}
