package com.cris.website.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usergroup")
public class UserGroupModel extends DefaultModel {
	private static final long serialVersionUID = 491793937580719013L;

	private String groupName;
	private List<UserModel> users;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@ManyToMany(targetEntity = UserModel.class, mappedBy = "userGroups", fetch = FetchType.EAGER)
	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}
}
