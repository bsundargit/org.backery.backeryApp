package org.backery.common;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * This file makes use of log4j to write the logs as per its defined level
 * (DEBUG,ERROR etc)
 * 
 * @author esxxbhs
 *
 */
public class BackeryLogger {
	private static Logger logger = Logger.getLogger(BackeryLogger.class);
	public static final BackeryLogger backeryLogger = new BackeryLogger();
	boolean debugEnable = true;

	public BackeryLogger() {
	}

	public static void log(Level level, Object message) {
		log(BackeryLogger.class.getCanonicalName(), level, message, null);
	}

	public static void log(Level level, Object message, Throwable t) {
		log(BackeryLogger.class.getCanonicalName(), level, message, t);
	}

	public static void log(String callerFQCN, Level level, Object message, Throwable t) {
		if (level.equals(Level.DEBUG)) {
			if (backeryLogger.debugEnable) {
				logger.log(callerFQCN, level, message, t);
			}
		} else {
			logger.log(callerFQCN, level, message, t);
		}
	}

}