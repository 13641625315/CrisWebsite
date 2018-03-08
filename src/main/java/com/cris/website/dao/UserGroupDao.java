package com.cris.website.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cris.website.model.UserGroupModel;

@Repository
public interface UserGroupDao extends JpaRepository<UserGroupModel, Integer> {
	UserGroupModel findByGroupName(String groupName);
}
