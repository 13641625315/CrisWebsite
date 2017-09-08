package com.cris.website.facades.impl;

import com.cris.website.facades.CrisWSFacades;
import com.cris.website.jasonbean.HeWeather;
import com.cris.website.service.CrisWSService;

public class CrisWSFacadesImpl implements CrisWSFacades {
	private CrisWSService crisWSService;
	
	@Override
	public HeWeather getWeatherForIP(String ip) {
		return crisWSService.getWeatherForIP(ip);
	}

	public CrisWSService getCrisWSService() {
		return crisWSService;
	}

	public void setCrisWSService(CrisWSService crisWSService) {
		this.crisWSService = crisWSService;
	}

	
}
