package com.cris.website.service.impl;

import com.cris.website.client.HeFengWeatherClient;
import com.cris.website.jasonbean.HeWeather;
import com.cris.website.service.CrisWSService;

public class CrisWSServiceImpl implements CrisWSService {
	private HeFengWeatherClient heFengWeatherClient;
	
	@Override
	public HeWeather getWeatherForIP(String ip) {
		return heFengWeatherClient.getWeatherForIP(ip);
	}

	public HeFengWeatherClient getHeFengWeatherClient() {
		return heFengWeatherClient;
	}

	public void setHeFengWeatherClient(HeFengWeatherClient heFengWeatherClient) {
		this.heFengWeatherClient = heFengWeatherClient;
	}
	
}
