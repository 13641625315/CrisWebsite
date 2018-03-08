package com.cris.website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cris.website.client.HeFengWeatherClient;
import com.cris.website.jasonbean.HeWeather;
import com.cris.website.service.CrisWSService;

@Service("crisWSService")
public class CrisWSServiceImpl implements CrisWSService {
	@Autowired
	private HeFengWeatherClient heFengWeatherClient;

	@Override
	public HeWeather getWeatherForIP(String ip) {
		return heFengWeatherClient.getWeatherForIP(ip);
	}

}
