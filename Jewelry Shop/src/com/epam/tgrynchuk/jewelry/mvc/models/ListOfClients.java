package com.epam.tgrynchuk.jewelry.mvc.models;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class ListOfClients extends ArrayList<Client> {
	private static final Logger LOGGER = Logger.getLogger(ListOfClients.class);
	{
		LOGGER.trace("ListOfClients {}");
	}
	
	private static final long serialVersionUID = 1L;

	
}
