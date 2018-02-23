package com.cris.website.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usergroup")
public class UserGroupModel extends DefaultModel {
	private static final long serialVersionUID = 491793937580719013L;
	
	private String groupname;
	private List<UserModel> users;

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	@ManyToMany(targetEntity = UserModel.class, mappedBy = "userGroups")
	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}
}
