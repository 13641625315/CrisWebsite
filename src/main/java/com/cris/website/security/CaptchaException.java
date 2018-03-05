package com.cris.website.security;

import org.springframework.security.core.AuthenticationException;

public class CaptchaException extends AuthenticationException {

	private static final long serialVersionUID = -1892200006427415606L;

	public CaptchaException(String msg) {
		super(msg);
	}
}