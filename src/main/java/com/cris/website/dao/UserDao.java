package com.cris.website.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cris.website.model.UserModel;

public interface UserDao extends JpaRepository<UserModel, Integer> {
	UserModel findByPhoneNum(String phoneNum);
}
