package com.cris.website.facades;

import com.cris.website.jasonbean.HeWeather;

public interface CrisWSFacades {
	HeWeather getWeatherForIP(String ip);
}
