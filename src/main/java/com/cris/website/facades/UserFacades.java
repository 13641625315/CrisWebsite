package com.cris.website.facades;

import com.cris.website.data.UserData;

public interface UserFacades {
	public abstract UserData findUserByPhoneNum(String phoneNum);
}
