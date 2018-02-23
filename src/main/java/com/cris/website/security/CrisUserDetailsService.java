package com.cris.website.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cris.website.model.UserGroupModel;
import com.cris.website.model.UserModel;
import com.cris.website.service.UserService;

@Service("crisUserDetailsService")
public class CrisUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	final Log LOG = LogFactory.getLog(getClass());

	private static String ADMIN_USER_GROUP_NAME = "Admin";

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String phoneNum) throws UsernameNotFoundException {
		UserModel user = userService.findUserByPhoneNum(phoneNum);
		if (user == null) {
			LOG.error("User not found");
			throw new UsernameNotFoundException("findUserByPhoneNum() User not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getPhoneNum(), user.getPassword(),
				user.getIsActive().equals("Active"), true, true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(UserModel user) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		if (null != user && CollectionUtils.isNotEmpty(user.getUserGroups())) {
			boolean isAdmin = false;
			for (UserGroupModel userGroupModel : user.getUserGroups()) {
				if (ADMIN_USER_GROUP_NAME.equals(userGroupModel.getGroupname())) {
					isAdmin = true;
					break;
				}
			}
			if (isAdmin) {
				authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}
		}
		return authorities;
	}

}