package com.epam.tgrynchuk.lab5logger;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class TestFilters {
	private static final Logger LOGGER = Logger.getLogger(TestFilters.class);
	
	public static void start() {
		LOGGER.trace("static Test  filters: trace");
		LOGGER.debug("static Test  filters: debug");
		LOGGER.info("static Test filters: info");
		LOGGER.warn("static Test filters: warn");
		LOGGER.error("static Test filters: error");
		LOGGER.fatal("static Test filters: fatal");
		
		new TestFilters().test();
	}
	
	public void test() {
		LOGGER.trace("Test filters: trace");
		LOGGER.debug("Test filters: debug");
		LOGGER.info("Test filters: info");
		LOGGER.warn("Test filters: warn");
		LOGGER.error("Test filters: error");
		LOGGER.fatal("Test filters: fatal");

		
		//org.apache.log4j.net.SMTPAppender s = new org.apache.log4j.net.SMTPAppender();
		
	}
	
}
