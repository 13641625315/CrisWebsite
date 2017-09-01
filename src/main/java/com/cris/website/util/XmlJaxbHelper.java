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
package com.cris.website.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 */
public class XmlJaxbHelper<T>
{
	private static final Logger LOG = LoggerFactory.getLogger(XmlJaxbHelper.class);

	//	public static <T> String marshal2(final T t) throws JAXBException
	//	{
	//		final Jaxb2Marshaller m = new Jaxb2Marshaller();
	//		m.setClassesToBeBound(t.getClass());
	//		final StringResult ret = new StringResult();
	//		m.marshal(t, ret);
	//		return ret.toString();
	//	}

	public static <T> String marshal(final T t) throws JAXBException
	{
		final StringWriter writer = new StringWriter();
		final JAXBContext jc = JAXBContext.newInstance(t.getClass());
		final Marshaller u = jc.createMarshaller();
		u.marshal(t, writer);
		return writer.toString();
	}

	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(final String xmlString, final Class<T> clazz) throws JAXBException
	{
		T resp = null;
		final ByteArrayInputStream stream = new ByteArrayInputStream(xmlString.getBytes());
		final JAXBContext jc = JAXBContext.newInstance(clazz);
		final Unmarshaller u = jc.createUnmarshaller();
		resp = (T) u.unmarshal(stream);
		try
		{
			stream.close();
		}
		catch (final IOException e)
		{
			LOG.error(e.getMessage());
		}
		return resp;
	}
}
