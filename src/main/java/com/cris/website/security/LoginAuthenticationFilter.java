package com.cris.website.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private static String CAPTCHA_VALUE = "captcha";
	private static String PHONENUM_ERROR_URL = "/loginPage?authenticated=phonenum";
	private static String PASS_ERROR_URL = "/loginPage?authenticated=pass";
	private static String CAPTCHA_ERROR_URL = "/loginPage?authenticated=captcha";

	public LoginAuthenticationFilter() {
		AntPathRequestMatcher requestMatcher = new AntPathRequestMatcher("/login", "POST");
		this.setRequiresAuthenticationRequestMatcher(requestMatcher);
		this.setAuthenticationManager(getAuthenticationManager());
		this.setAuthenticationFailureHandler(authenticationFailureHandler());
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String verification = request.getParameter("loginCaptcha");
		String captcha = (String) request.getSession().getAttribute(CAPTCHA_VALUE);

		if (!captcha.contentEquals(verification)) {
			throw new CaptchaException("captcha code not matched!");
		}
		return super.attemptAuthentication(request, response);
	}

	public AuthenticationFailureHandler authenticationFailureHandler() {
		ExceptionMappingAuthenticationFailureHandler failureHandler = new ExceptionMappingAuthenticationFailureHandler();
		Map<String, String> failureUrlMap = new HashMap<>();
		failureUrlMap.put(UsernameNotFoundException.class.getName(), PHONENUM_ERROR_URL);
		failureUrlMap.put(BadCredentialsException.class.getName(), PASS_ERROR_URL);
		failureUrlMap.put(CaptchaException.class.getName(), CAPTCHA_ERROR_URL);
		failureHandler.setExceptionMappings(failureUrlMap);
		return failureHandler;
	}
}