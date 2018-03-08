package com.cris.website.facades.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cris.website.facades.CrisWSFacades;
import com.cris.website.jasonbean.HeWeather;
import com.cris.website.service.CrisWSService;

@Component("crisWSFacades")
public class CrisWSFacadesImpl implements CrisWSFacades {
	@Autowired
	private CrisWSService crisWSService;

	@Override
	public HeWeather getWeatherForIP(String ip) {
		return crisWSService.getWeatherForIP(ip);
	}

}
