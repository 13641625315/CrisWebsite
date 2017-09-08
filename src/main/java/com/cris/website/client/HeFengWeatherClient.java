/**
 *
 */
package com.cris.website.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.cris.website.exception.JsonConverterException;
import com.cris.website.jasonbean.HeWeather;
import com.cris.website.util.JacksonHelper;

public class HeFengWeatherClient
{
	@Value("#{constants.hefengweatherUrl}")
    public String hefengweatherUrl;
	
	@Value("#{constants.hefengweatherKey}")
    public String hefengweatherKey;
	
	private RestTemplate restTemplate;
	
	public HeWeather getWeatherForIP(final String ip)
	{
		 String responseBody=restTemplate.getForObject("https://free-api.heweather.com/v5/now?city=210.13.112.211&key=a00e1da7db394e0a8f6b6c30c665482b", String.class);
		 try {
			return JacksonHelper.fromJSON(responseBody, HeWeather.class);
		} catch (JsonConverterException e) {
			e.printStackTrace();
		}
		return null;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
