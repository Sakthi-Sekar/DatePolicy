package com.MyArchetype.helper;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.MyArchetype.utility.ConstantPaths;

public class LogReports {
	Logger logger = null;

	public LogReports() {

		getlogger();
		logger = Logger.getLogger(LogReports.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator.configure(ConstantPaths.log4jPropertiesFilePath);
	}

	public void info(String message) {
		logger.info(message);
	}

	public void debug(String message) {

	}

}