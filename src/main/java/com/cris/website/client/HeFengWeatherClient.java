/**
 *
 */
package com.cris.website.client;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.sun.tools.internal.ws.processor.model.Response;

public class HeFengWeatherClient
{
	private final static Logger LOG = LoggerFactory.getLogger(HeFengWeatherClient.class);

	@Value("#{constants.hefengweatherUrl}")
    public String hefengweatherUrl;
	
	@Value("#{constants.hefengweatherKey}")
    public String hefengweatherKey;
	
	private RestTemplate restTemplate;
	
	public String getWeatherForIP(final String ip)
	{
		Map<String,String> urlVariables=new HashMap<>();
		urlVariables.put("city", ip);
		urlVariables.put("key", hefengweatherKey);
		return restTemplate.getForObject(hefengweatherUrl, String.class, urlVariables); 
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
}
