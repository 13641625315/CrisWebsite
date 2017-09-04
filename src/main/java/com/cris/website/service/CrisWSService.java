package com.cris.website.service;

import com.cris.website.jasonbean.HeWeather;

public interface CrisWSService {
	public HeWeather getWeatherForIP(String ip);
}
