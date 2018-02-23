package com.cris.website.dao;

import com.cris.website.model.UserModel;

public interface UserDao extends CrisAbstractDao {
	public abstract UserModel findUserByPhoneNum(String phoneNum);
}
