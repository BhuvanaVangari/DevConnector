package com.dnb.DevConnector.utils;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.hibernate.type.spi.TypeConfiguration;

public class CustomIdGenerator extends SequenceStyleGenerator {
	public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
	public static final String VALUE_PREFIX_DEFAULT = "";
	public static final String DATE_FORMAT_PARAMETER = "dateFormat";
	public static final String DATE_FORMAT_DEFAULT = "%tY-%tm";
	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT = "%05d";
	public static final String SEPARATOR_PARAMETER = "dateNumberSeparator";
	public static final String SEPARATOR_DEFAULT = "_";
	public static final String BOOLEAN_FORMAT_PARAMETER = "booleanFormat";
	public static final String BOOLEAN_FORMAT_DEFAULT = "";

	private String format;

	@Override
	public Serializable generate(SharedSessionContractImplementor session,Object object) throws HibernateException {
		return String.format(format, LocalDate.now(), super.generate(session, object));
	}

	@Override
	public void configure(Type type, Properties params,ServiceRegistry serviceRegistry) throws MappingException {

//        super.configure(LongType.INSTANCE, params, serviceRegistry);

		super.configure(new TypeConfiguration().getBasicTypeRegistry().getRegisteredType(Long.class), params, serviceRegistry);

		String valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, params, VALUE_PREFIX_DEFAULT);
		
		String dateFormat = ConfigurationHelper.getString(DATE_FORMAT_PARAMETER, params, DATE_FORMAT_DEFAULT).replace("%", "%1");

		String numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT).replace("%", "");

		String separator = ConfigurationHelper.getString(SEPARATOR_PARAMETER, params,SEPARATOR_DEFAULT);
		
		String booleanFormat =ConfigurationHelper.getString(BOOLEAN_FORMAT_PARAMETER, params, DATE_FORMAT_DEFAULT);

		if(booleanFormat.equals("true")) {
			this.format=valuePrefix + dateFormat + separator + numberFormat;
		}
		else {
			this.format = valuePrefix + separator + numberFormat;
		}

	}

//	@Override
//	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//		// TODO Auto-generated method stub
//		return valuePrefix + String.format(numberFormat, super.generate(session, object));
//	}
//
//	@Override
//	public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) throws MappingException {
//		// TODO Auto-generated method stub
//		super.configure(new TypeConfiguration().getBasicTypeRegistry().getRegisteredType(Long.class), parameters,
//				serviceRegistry);
//		valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, parameters, VALUE_PREFIX_DEFAULT);
//		numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, parameters, NUMBER_FORMAT_DEFAULT);
//	}
}
