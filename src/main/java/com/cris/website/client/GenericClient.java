/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2017 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package com.cris.website.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import com.cris.website.bean.webservice.AbstractResponse;
import com.cris.website.exception.JsonConverterException;
import com.cris.website.util.HttpHelper;
import com.cris.website.util.JacksonHelper;
import com.cris.website.util.XmlJaxbHelper;



/**
 */
public class GenericClient
{
	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(GenericClient.class);

	private RestTemplate restTemplate;
	private WebServiceTemplate soapTemplate;
	private HttpHeaders jsonHeaders;

	private final static Map<String, String> emptyMap = new HashMap<>();



	protected <RESPONSE extends AbstractResponse> RESPONSE restGet(final String url, final Map<String, String> urlVariables,
			final Class<RESPONSE> responseType)
	{
		try
		{
			String qstr = url;
			if ((urlVariables != null) && (!urlVariables.isEmpty()))
			{
				qstr += "?" + HttpHelper.generateQueryString(urlVariables, "UTF-8");
			}
			final HttpEntity<String> requestEntity = new HttpEntity<String>(getJsonHeaders());
			final ResponseEntity<RESPONSE> response = getRestTemplate().exchange(qstr, HttpMethod.GET, requestEntity, responseType,
					emptyMap);
			return response.getBody();
		}
		catch (final ResourceAccessException e)
		{
			LOG.error(e.getMessage());
			return this.generateErrorResponse(responseType, "CC_TIMED_OUT", e.getMessage());
		}
		catch (final Exception e)
		{
			LOG.error(e.getMessage());
			return this.generateErrorResponse(responseType, "", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	protected <RESPONSE extends AbstractResponse> RESPONSE restPost(final String url, final Object request,
			final Class<RESPONSE> responseType)
	{
		RESPONSE resp = null;
		try
		{
			final HttpEntity<String> requestEntity = new HttpEntity<String>(JacksonHelper.toJSON(request), getJsonHeaders());
			final ResponseEntity<RESPONSE> response = getRestTemplate().exchange(url, HttpMethod.POST, requestEntity, responseType,
					emptyMap);

			resp = response.getBody();
		}
		catch (final JsonConverterException e)
		{
			LOG.error(e.getMessage());
			resp = this.generateErrorResponse(responseType, "", e.getMessage());
		}
		return resp;
	}

	@SuppressWarnings(
	{ "unchecked", "rawtypes" })
	protected <RESPONSE extends AbstractResponse> RESPONSE restPut(final String url, final Object request,
			final Class<RESPONSE> responseType)
	{
		RESPONSE resp = null;
		try
		{
			final HttpEntity<String> requestEntity = new HttpEntity<String>(JacksonHelper.toJSON(request), getJsonHeaders());
			final ResponseEntity<RESPONSE> response = getRestTemplate().exchange(url, HttpMethod.PUT, requestEntity, responseType,
					emptyMap);
			resp = response.getBody();
			LOG.debug("finished calling restPut, get the body.");
		}
		catch (final Exception e)
		{
			LOG.error(e.getMessage());
			resp = this.generateErrorResponse(responseType, "", e.getMessage());
		}
		return resp;
	}

	protected <RESPONSE extends AbstractResponse> RESPONSE soap(final String url, final Object request,
			final Class<RESPONSE> responseType)
	{
		RESPONSE resp = null;
		try
		{
			final StringSource requestPayload = new StringSource(XmlJaxbHelper.marshal(request));
			final StringResult responseResult = new StringResult();
			soapTemplate.sendSourceAndReceiveToResult(url, requestPayload, responseResult);
			resp = parseXml(responseResult.toString(), responseType);
		}
		catch (final Exception e)
		{
			LOG.error(e.getMessage());
			resp = this.generateErrorResponse(responseType, "", e.getMessage());
		}
		return resp;
	}


	/**
	 * generate the default response based on the error code and message.
	 *
	 * @param responseType
	 * @param errCode
	 * @param errMsg
	 * @return
	 */
	@SuppressWarnings("javadoc")
	protected <RESPONSE extends AbstractResponse> RESPONSE generateErrorResponse(final Class<RESPONSE> responseType,
			final String errCode, final String errMsg)
	{

		AbstractResponse resp = null;
		RESPONSE ret = null;
		try
		{
			ret = responseType.newInstance();
			resp = ret;
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			LOG.error(e.getMessage());
			return null;
		}
		resp.setErrorCode(errCode);
		resp.setErrorMessage(errMsg);
		return ret;
	}


	protected <RESPONSE extends AbstractResponse> RESPONSE parseXml(final String xmlStr, final Class<RESPONSE> responseType)
			throws JAXBException, SOAPException, IOException
	{
		return XmlJaxbHelper.unmarshal(xmlStr, responseType);
	}

	protected <RESPONSE extends AbstractResponse> RESPONSE parseJSON(final String jsonStr, final Class<RESPONSE> responseType)
			throws JsonConverterException
	{
		return JacksonHelper.fromJSON(jsonStr, responseType);
	}


	public RestTemplate getRestTemplate()
	{
		return restTemplate;
	}


	public void setRestTemplate(final RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}

	public WebServiceTemplate getSoapTemplate()
	{
		return soapTemplate;
	}

	public void setSoapTemplate(final WebServiceTemplate soapTemplate)
	{
		this.soapTemplate = soapTemplate;
	}

	public HttpHeaders getJsonHeaders()
	{
		return jsonHeaders;
	}

	public void setJsonHeaders(final HttpHeaders jsonHeaders)
	{
		this.jsonHeaders = jsonHeaders;
	}



}
