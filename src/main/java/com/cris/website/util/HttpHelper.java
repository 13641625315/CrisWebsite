package com.cris.website.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;



public class HttpHelper
{

	/**
	 * get the charset from content-type. if not found,return default UTF-8
	 */
	public static String getCharset(final String contentType)
	{
		if (!StringUtils.isEmpty(contentType))
		{
			final String segs[] = StringUtils.trim(contentType).split(";");
			for (final String seg : segs)
			{
				if (seg.indexOf("=") > 0)
				{
					final String words[] = seg.split("=");
					for (int i = 0; i < words.length; i++)
					{
						if ("charset".equalsIgnoreCase(words[i]))
						{
							if (i < (words.length - 1))
							{
								return words[i + 1];
							}
						}
					}
				}
			}
		}

		return null;
	}

	/**
	 * get the charset from content-type. if not found,return default UTF-8
	 *
	 * @throws UnsupportedEncodingException
	 */
	public static String generateQueryString(final Map<String, String> paramMap, final String enc)
			throws UnsupportedEncodingException
	{
		if (MapUtils.isEmpty(paramMap))
		{
			return "";
		}
		StringBuffer params = new StringBuffer();
		for (final String key : paramMap.keySet())
		{
			if (StringUtils.isNotBlank(key))
			{
				params.append(key);
				params.append("=");
				if (StringUtils.isNotEmpty(paramMap.get(key)))
				{
					params.append(URLEncoder.encode(paramMap.get(key), enc));
				}
				params.append("&");
			}
		}

		if (params.length() > 0)
		{
			params = params.deleteCharAt(params.length() - 1);
		}
//		if (LOG.isDebugEnabled())
//		{
//			LOG.debug("Rest request params:[{}]", params.toString());
//		}
		return params.toString();
	}


	public static NameValuePair[] generatNameValuePair(final Map<String, String> properties)
	{
		final NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
		int i = 0;
		for (final Map.Entry<String, String> entry : properties.entrySet())
		{
			nameValuePair[i++] = new NameValuePair(entry.getKey(), entry.getValue());
		}

		return nameValuePair;
	}

	public static String convertStreamToString(final InputStream is)
	{
		final StringBuilder sb = new StringBuilder();
		String line = null;
		try
		{
			final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			while ((line = reader.readLine()) != null)
			{
				sb.append(line);
			}
		}
		catch (final IOException e)
		{
//			LOG.error(e.getMessage());
		}
		return sb.toString();
	}

	public static String request2String(final HttpRequest request)
	{
		final StringBuffer sb = new StringBuffer();
		request.getHeaders().forEach((entry, vlist) -> {
			sb.append(entry).append(" : ");
			vlist.forEach(v -> {
				sb.append(v).append(" , ");
			});
			sb.append("\n");
		});

		return sb.toString();
	}

	public static String response2String(final ClientHttpResponse response)
	{
		final StringBuffer sb = new StringBuffer();
		try
		{
			sb.append(response.getStatusCode()).append("\n");
		}
		catch (final IOException e1)
		{
//			LOG.error("read http response error 1:", e1);
		}
		response.getHeaders().forEach((entry, vlist) -> {
			sb.append(entry).append(" : ");
			vlist.forEach(v -> {
				sb.append(v).append(" , ");
			});
			sb.append("\n");
		});
		sb.append("\n");
		try
		{
			sb.append(convertStreamToString(response.getBody())).append("\n");
		}
		catch (final IOException e2)
		{
//			LOG.error("read http response error 2:", e2);
		}
		return sb.toString();
	}
}
