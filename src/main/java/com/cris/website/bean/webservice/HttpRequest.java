package com.cris.website.bean.webservice;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;


/**
 * The Class HttpRequest.
 */
public class HttpRequest
{

	/** HTTP GET method. */
	public static final String METHOD_GET = "GET";

	/** HTTP POST method. */
	public static final String METHOD_POST = "POST";

	/** HTTP PUT method. */
	public static final String METHOD_PUT = "PUT";

	/** The url. */
	private String url = null;

	/** The method. */
	private String method = METHOD_POST;

	/** The timeout. */
	private int timeout = 0;

	/** The connection timeout. */
	private int connectionTimeout = 0;

	/** The parameters. */
	private NameValuePair[] parameters = null;

	/** The query string. */
	private String queryString = null;

	/** The charset. */
	private String charset = "UTF-8";

	/** The result type. */
	private HttpResultType resultType = HttpResultType.BYTES;

	/** The body str. */
	private String bodyStr;

	/** The content type. */
	private String contentType = "application/x-www-form-urlencoded; text/html; charset=" + charset;

	/** The headers. */
	private Map<String, String> headers = new HashMap<>();

	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
	public Map<String, String> getHeaders()
	{
		return headers;
	}

	/**
	 * Sets the headers.
	 *
	 * @param headers
	 *           the headers
	 */
	public void setHeaders(final Map<String, String> headers)
	{
		this.headers = headers;
	}

	/**
	 * Instantiates a new http request.
	 *
	 * @param resultType
	 *           the result type
	 */
	public HttpRequest(final HttpResultType resultType)
	{
		super();
		this.resultType = resultType;
	}

	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	public NameValuePair[] getParameters()
	{
		return parameters;
	}

	/**
	 * Sets the parameters.
	 *
	 * @param parameters
	 *           the new parameters
	 */
	public void setParameters(final NameValuePair[] parameters)
	{
		this.parameters = parameters;
	}

	/**
	 * Gets the query string.
	 *
	 * @return the query string
	 */
	public String getQueryString()
	{
		return queryString;
	}

	/**
	 * Sets the query string.
	 *
	 * @param queryString
	 *           the new query string
	 */
	public void setQueryString(final String queryString)
	{
		this.queryString = queryString;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url
	 *           the new url
	 */
	public void setUrl(final String url)
	{
		this.url = url;
	}

	/**
	 * Gets the method.
	 *
	 * @return the method
	 */
	public String getMethod()
	{
		return method;
	}

	/**
	 * Sets the method.
	 *
	 * @param method
	 *           the new method
	 */
	public void setMethod(final String method)
	{
		this.method = method;
	}

	/**
	 * Gets the connection timeout.
	 *
	 * @return the connection timeout
	 */
	public int getConnectionTimeout()
	{
		return connectionTimeout;
	}

	/**
	 * Sets the connection timeout.
	 *
	 * @param connectionTimeout
	 *           the new connection timeout
	 */
	public void setConnectionTimeout(final int connectionTimeout)
	{
		this.connectionTimeout = connectionTimeout;
	}

	/**
	 * Gets the timeout.
	 *
	 * @return the timeout
	 */
	public int getTimeout()
	{
		return timeout;
	}

	/**
	 * Sets the timeout.
	 *
	 * @param timeout
	 *           the new timeout
	 */
	public void setTimeout(final int timeout)
	{
		this.timeout = timeout;
	}

	/**
	 * Gets the charset.
	 *
	 * @return Returns the charset.
	 */
	public String getCharset()
	{
		return charset;
	}

	/**
	 * Sets the charset.
	 *
	 * @param charset
	 *           The charset to set.
	 */
	public void setCharset(final String charset)
	{
		this.charset = charset;
	}

	/**
	 * Gets the result type.
	 *
	 * @return the result type
	 */
	public HttpResultType getResultType()
	{
		return resultType;
	}

	/**
	 * Sets the result type.
	 *
	 * @param resultType
	 *           the new result type
	 */
	public void setResultType(final HttpResultType resultType)
	{
		this.resultType = resultType;
	}

	/**
	 * Gets the content type.
	 *
	 * @return the contentType
	 */
	public String getContentType()
	{
		return contentType;
	}

	/**
	 * Sets the content type.
	 *
	 * @param contentType
	 *           the contentType to set
	 */
	public void setContentType(final String contentType)
	{
		this.contentType = contentType;
	}

	public String getBodyStr()
	{
		return bodyStr;
	}

	public void setBodyStr(final String bodyStr)
	{
		this.bodyStr = bodyStr;
	}



	@Override
	public String toString()
	{
		final StringBuilder request = new StringBuilder("{\n");
		request.append("  method : " + method + ",\n");
		request.append("  url : " + url + ",\n");
		request.append("  headers : [ ");
		for (final Map.Entry<String, String> header : headers.entrySet())
		{
			request.append("{\n");
			request.append("    name : " + header.getKey() + ",\n");
			request.append("    value : " + header.getValue() + "\n  }, ");
		}
		request.append("],\n");
		request.append("  body : {\n");
		request.append("    charset : " + charset + ",\n");
		request.append("    contentType : " + contentType + ",\n");
		request.append("    resultType : " + resultType.toString() + ",\n");
		request.append("    queryString : " + queryString + ",\n");
		for (int i = 0; parameters != null && i < parameters.length; i++)
		{
			request.append("    parameters : " + parameters[i].toString() + ",\n");
		}
		request.append("    bodyStr : " + bodyStr + "\n  }\n}");

		return request.toString();
	}

}
