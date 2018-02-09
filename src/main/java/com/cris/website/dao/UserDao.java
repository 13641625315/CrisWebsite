package com.cris.website.dao;

import com.cris.website.model.User;

public interface UserDao extends CrisAbstractDao {
	public abstract User findUserByPhoneNum(String phoneNum);
}
