package com.cris.website.model;

public class User {
	private Integer uid;
	private Integer phoneNum;
	private String password;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Integer phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// CREATE TABLE `criswebsite`.`user` (
	// `uid` INT NOT NULL,
	// `phoneNum` VARCHAR(20) NOT NULL,
	// `password` VARCHAR(20) NOT NULL,
	// PRIMARY KEY (`uid`),
	// UNIQUE INDEX `uid_UNIQUE` (`uid` ASC),
	// UNIQUE INDEX `phoneNum_UNIQUE` (`phoneNum` ASC));

}
