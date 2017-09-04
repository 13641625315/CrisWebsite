package com.cris.website.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cris.website.exception.JsonConverterException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;


/**
 * The Class JacksonHelper.
 *
 */
public class JacksonHelper
{

	/** The Constant LOG. */
	private final static Logger LOG = LoggerFactory.getLogger(JacksonHelper.class);

	/** The to JSON mapper. */
	private static ObjectMapper toJSONMapper = new ObjectMapper();

	/** The from JSON mapper. */
	private static ObjectMapper fromJSONMapper = new ObjectMapper();

	static
	{
		fromJSONMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		fromJSONMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

	}

	/**
	 * * transform object to json format string.
	 *
	 * @param obj
	 *           the obj
	 * @return the string
	 * @throws BcfJsonConverterException
	 *            the json converter exception
	 */
	public static String toJSON(final Object obj) throws JsonConverterException
	{
		final ObjectMapper mapper = toJSONMapper;
		final StringWriter writer = new StringWriter();
		try
		{
			mapper.writeValue(writer, obj);
			return writer.toString();
		}
		catch (final Exception e)
		{
			LOG.error("generate jsonData error " + obj, e);
			throw new JsonConverterException(e);
		}

	}

	public static String toJSON(final Object obj, final JacksonAnnotationIntrospector jacksonAnnotationIntrospector)
			throws JsonConverterException
	{
		final ObjectMapper mapper = toJSONMapper;
		if (jacksonAnnotationIntrospector != null)
		{
			mapper.setAnnotationIntrospector(jacksonAnnotationIntrospector);
		}

		return toJSON(obj);
	}

	/**
	 * * transform object to json format string to appointed OutStream use appointed CharSet.
	 *
	 * @param obj
	 *           the obj
	 * @param stream
	 *           the stream
	 * @param charset
	 *           the charset
	 * @throws BcfJsonConverterException
	 *            the json converter exception
	 */
	public static void toJSON(final Object obj, final OutputStream stream, final String charset) throws JsonConverterException
	{
		final ObjectMapper mapper = toJSONMapper;
		try
		{
			final OutputStreamWriter writer = new OutputStreamWriter(stream, charset);
			mapper.writeValue(writer, obj);
		}
		catch (final Exception e)
		{
			throw new JsonConverterException(e);
		}
	}

	/**
	 * * transform string which json format to appointed type.
	 *
	 * @param <T>
	 *           the generic type
	 * @param json
	 *           the json
	 * @param clazz
	 *           the clazz
	 * @return the t
	 * @throws BcfJsonConverterException
	 *            the json converter exception
	 */
	public static <T> T fromJSON(final String json, final Class<T> clazz) throws JsonConverterException
	{
		final ObjectMapper mapper = fromJSONMapper;
		try
		{
			return mapper.readValue(json, clazz);
		}
		catch (final Exception e)
		{
			throw new JsonConverterException(e);
		}
	}

	/**
	 * * transform string which json format to appointed type use by InputStream.
	 *
	 * @param <T>
	 *           the generic type
	 * @param json
	 *           the json
	 * @param clazz
	 *           the clazz
	 * @return the t
	 * @throws BcfJsonConverterException
	 *            the json converter exception
	 */
	public static <T> T fromJSON(final InputStream json, final Class<T> clazz) throws JsonConverterException
	{
		final ObjectMapper mapper = fromJSONMapper;
		try
		{
			return mapper.readValue(json, clazz);
		}
		catch (final Exception e)
		{
			throw new JsonConverterException(e);
		}
	}

	/**
	 * To JSON list.
	 *
	 * @param <T>
	 *           the generic type
	 * @param list
	 *           the list
	 * @return the string
	 * @throws BcfJsonConverterException
	 *            the json converter exception
	 */
	public static <T> String toJSONList(final List<T> list) throws JsonConverterException
	{
		String jsonVal = null;
		try
		{
			jsonVal = toJSONMapper.writeValueAsString(list);
		}
		catch (final Exception e)
		{
			throw new JsonConverterException(e);
		}
		return jsonVal;
	}

	/**
	 * From JSON list.
	 *
	 * @param <T>
	 *           the generic type
	 * @param jsonVal
	 *           the json val
	 * @param clazz
	 *           the clazz
	 * @return the list
	 * @throws BcfJsonConverterException
	 *            the json converter exception
	 */
	public static <T> List<T> fromJSONList(final String jsonVal, final Class<?> clazz) throws JsonConverterException
	{

		List<T> list = null;
		try
		{
			list = fromJSONMapper.readValue(jsonVal, TypeFactory.defaultInstance().constructCollectionType(List.class, clazz));
		}
		catch (final Exception e)
		{
			throw new JsonConverterException(e);
		}
		return list;
	}



}
