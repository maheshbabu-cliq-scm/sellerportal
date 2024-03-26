package com.sellerportal.custom.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;
import org.apache.logging.log4j.util.MessageSupplier;
import org.apache.logging.log4j.util.Supplier;

import com.sellerportal.custom.logging.enums.Event;
import com.sellerportal.custom.logging.enums.UserAction;
import com.sellerportal.ism.SessionVariablesBean;
import com.anm.jsf.utils.FacesUtils;

/**
 * Extended Logger interface with convenience methods for the AUDIT custom log
 * level.
 * <p>
 * Compatible with Log4j 2.6 or higher.
 * </p>
 */
public final class CustomLogger extends ExtendedLoggerWrapper {
	private static final long serialVersionUID = 4868713459724800L;
	private final ExtendedLoggerWrapper logger;
	private static final String FQCN = CustomLogger.class.getName();
	private static final Level AUDIT = Level.forName("AUDIT", 50);

	private CustomLogger(final Logger logger) {
		super((AbstractLogger) logger, logger.getName(), logger.getMessageFactory());
		this.logger = this;
	}

	/**
	 * Returns a custom Logger with the name of the calling class.
	 * 
	 * @return The custom Logger for the calling class.
	 */
	public static CustomLogger getLogger() {
		final Logger wrapped = LogManager.getLogger();
		return new CustomLogger(wrapped);
	}

	/**
	 * Returns a custom Logger using the fully qualified name of the Class as the
	 * Logger name.
	 * 
	 * @param loggerName The Class whose name should be used as the Logger name. If
	 *                   null it will default to the calling class.
	 * @return The custom Logger.
	 */
	public static CustomLogger getLogger(final Class<?> loggerName) {
		final Logger wrapped = LogManager.getLogger(loggerName);
		return new CustomLogger(wrapped);
	}

	/**
	 * Returns a custom Logger using the fully qualified name of the Class as the
	 * Logger name.
	 * 
	 * @param loggerName     The Class whose name should be used as the Logger name.
	 *                       If null it will default to the calling class.
	 * @param messageFactory The message factory is used only when creating a
	 *                       logger, subsequent use does not change the logger but
	 *                       will log a warning if mismatched.
	 * @return The custom Logger.
	 */
	public static CustomLogger getLogger(final Class<?> loggerName, final MessageFactory messageFactory) {
		final Logger wrapped = LogManager.getLogger(loggerName, messageFactory);
		return new CustomLogger(wrapped);
	}

	/**
	 * Returns a custom Logger using the fully qualified class name of the value as
	 * the Logger name.
	 * 
	 * @param value The value whose class name should be used as the Logger name. If
	 *              null the name of the calling class will be used as the logger
	 *              name.
	 * @return The custom Logger.
	 */
	public static CustomLogger getLogger(final Object value) {
		final Logger wrapped = LogManager.getLogger(value);
		return new CustomLogger(wrapped);
	}

	/**
	 * Returns a custom Logger using the fully qualified class name of the value as
	 * the Logger name.
	 * 
	 * @param value          The value whose class name should be used as the Logger
	 *                       name. If null the name of the calling class will be
	 *                       used as the logger name.
	 * @param messageFactory The message factory is used only when creating a
	 *                       logger, subsequent use does not change the logger but
	 *                       will log a warning if mismatched.
	 * @return The custom Logger.
	 */
	public static CustomLogger getLogger(final Object value, final MessageFactory messageFactory) {
		final Logger wrapped = LogManager.getLogger(value, messageFactory);
		return new CustomLogger(wrapped);
	}

	/**
	 * Returns a custom Logger with the specified name.
	 * 
	 * @param name The logger name. If null the name of the calling class will be
	 *             used.
	 * @return The custom Logger.
	 */
	public static CustomLogger getLogger(final String name) {
		final Logger wrapped = LogManager.getLogger(name);
		return new CustomLogger(wrapped);
	}

	/**
	 * Returns a custom Logger with the specified name.
	 * 
	 * @param name           The logger name. If null the name of the calling class
	 *                       will be used.
	 * @param messageFactory The message factory is used only when creating a
	 *                       logger, subsequent use does not change the logger but
	 *                       will log a warning if mismatched.
	 * @return The custom Logger.
	 */
	public static CustomLogger getLogger(final String name, final MessageFactory messageFactory) {
		final Logger wrapped = LogManager.getLogger(name, messageFactory);
		return new CustomLogger(wrapped);
	}

	/**
	 * Logs a message with the event and action at the {@code AUDIT} level.
	 * 
	 * @param marker the marker data specific to this log statement
	 * @param msg    the message string to be logged
	 */

	public void audit(final Event event, final UserAction action, final String message) {
		SessionVariablesBean svb = (SessionVariablesBean) FacesUtils.getManagedBean("SessionVariablesBean");
		if(svb.getIpAddress()!=null && !svb.getIpAddress().isEmpty()) {
			ThreadContext.put("userIpAddress", svb.getIpAddress());			
		}
		ThreadContext.put("user", svb.getUserLoginId());
		ThreadContext.put("userType", svb.getUserType());
		ThreadContext.put("event", event != null ? event.toString() : null);
		ThreadContext.put("action", action != null ? action.toString() : null);
		logger.logIfEnabled(FQCN, AUDIT, null, message, null, null);
	}
}
