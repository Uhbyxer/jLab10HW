package com.epam.tgrynchuk.jdbcdemo.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import com.epam.tgrynchuk.jdbcdemo.dao.GroupDAO;
import com.epam.tgrynchuk.jdbcdemo.model.Group;

public class GroupService {
	public static Group getGroupByID(Integer id) throws SQLException {
		return GroupDAO.getGroupByID(id);
	}
	
	public static List<Group> getListOfGroups() throws SQLException, NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return GroupDAO.getListOfGroups();
	}
	
	public static void newGroup(String name) throws SQLException {
		GroupDAO.newGroup(name);
	}
	
	public static void delGroupByName(String name) throws SQLException {
		GroupDAO.delGroupByName(name);
	}
	
	public static void renGroupByID(Integer id, String name) throws SQLException {
		GroupDAO.renGroupByID(id, name);
	}
}
