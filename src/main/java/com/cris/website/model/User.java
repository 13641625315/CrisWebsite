package com.cris.website.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	private String uid;
	private String phoneNum;
	private String password;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
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
