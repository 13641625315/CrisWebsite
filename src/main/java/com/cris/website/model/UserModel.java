package com.cris.website.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "phoneNum") })
public class UserModel extends DefaultModel {
	private static final long serialVersionUID = -2341903918651859293L;
	
	private String phoneNum;
	private String nickName;
	private String password;
	private Boolean isActive;
	private List<UserGroupModel> userGroups;

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@ManyToMany(targetEntity = UserGroupModel.class)
	@Cascade({ CascadeType.SAVE_UPDATE })
	@JoinTable(name = "rel_user_usergroup", joinColumns = @JoinColumn(name = "user", referencedColumnName = "phoneNum"), inverseJoinColumns = @JoinColumn(name = "usergroup", referencedColumnName = "groupname"))
	public List<UserGroupModel> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<UserGroupModel> userGroups) {
		this.userGroups = userGroups;
	}

}
