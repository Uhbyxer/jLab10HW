package com.epam.tgrynchuk.lab5logger;

import java.util.Arrays;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.NDC;

public class TestLogger {
	static
	{
	     System.setProperty("mail.smtp.auth", "true");
	     System.setProperty("mail.smtp.socketFactory.port", "465");
	     System.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	     System.setProperty("mail.smtp.socketFactory.fallback", "false");
	     System.setProperty("mail.smtp.user","noreply.log4jrobot@gmail.com");
	     System.setProperty("mail.smtp.starttls.enable","true");
	     System.setProperty("mail.transport.protocol", "smtp");
	     System.setProperty("mail.smtp.starttls.enable", "true");
	     System.setProperty("mail.smtp.host", "smtp.gmail.com");
	     System.setProperty("mail.smtp.port", "465");
	     System.setProperty("mail.smtp.quitwait", "false");
	}
	
	private static final Logger LOGGER = Logger.getLogger(TestLogger.class);
	public static void main(String[] args) {
		NDC.push("a");
		a();
		NDC.pop(); 
		
		LOGGER.error("some error");
		
		LOGGER.debug("DEBUG!!!");
		
		
		
		try {
			throw new Exception("Some exception");
		} catch(Exception e) {
			LOGGER.error(e, e);
		}
		
		LOGGER.info("Info!!!!!!!!!!!!!!!!!!");
		LOGGER.trace("tracing....");
		LOGGER.warn("warning");
		LOGGER.fatal("Fatality !!!");
		
		TestFilters.start();
	}

	public static void a() {
		LOGGER.error("error in a");
		NDC.push("b");
		b();
		NDC.pop(); 
	}
	
	public static void b() {
		LOGGER.error("error in b");
	}
	
	
}


