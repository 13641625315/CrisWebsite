package com.cris.website.dao;

import com.cris.website.model.User;

public interface UserDao {
	  public abstract User findUserByPhonenum(Integer phoneNum);
}
