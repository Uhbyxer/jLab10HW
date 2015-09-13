package com.epam.tgrynchuk.jdbcdemo.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.tgrynchuk.jdbcdemo.model.Group;
import com.epam.tgrynchuk.jdbcdemo.persistant.ConnectionManager;
import com.epam.tgrynchuk.jdbcdemo.treansformer.GenericTransformer;


public class GroupDAO {
	
	public static Group getGroupByID(Integer id) throws SQLException {
		Group res = null;
		
		PreparedStatement stmt = ConnectionManager.getConnection()
				.prepareStatement("SELECT * FROM groups g WHERE g.id = ?;");
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			res = new Group();
			res.setId(rs.getInt("id"));
			res.setName(rs.getString("name"));
		}
		rs.close();
		stmt.close();
		
		return res;
	}
	
	public static List<Group> getListOfGroups() throws SQLException, NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		List<Group> res = new ArrayList<Group>();
		
		PreparedStatement stmt = ConnectionManager.getConnection()
				.prepareStatement("SELECT * FROM groups");
		
		ResultSet rs = stmt.executeQuery();
		
//		while(rs.next()) {
//			res.add(new Group(rs.getInt("id"), rs.getString("name")));
//		}
		
		List<Group> res = GenericTransformer.ResultSetToListOfObjects(rs, Group.class);
		
		
		rs.close();
		stmt.close();		
		return res;
	}
	
	public static void newGroup(String name) throws SQLException {
		PreparedStatement stmt = ConnectionManager.getConnection()
				.prepareStatement("INSERT groups (name) VALUES (?);");
		stmt.setString(1, name);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	public static void delGroupByName(String name) throws SQLException {
		PreparedStatement stmt = ConnectionManager.getConnection()
				.prepareStatement("DELETE FROM groups WHERE name = ?;");
		stmt.setString(1, name);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	public static void delGroupByID(Integer id) throws SQLException {
		PreparedStatement stmt = ConnectionManager.getConnection()
				.prepareStatement("DELETE FROM groups WHERE id = ?;");
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		stmt.close();
	}	
	
//	public static void delGroupByName(String name, Integer newGroupID)
//			throws SQLException {
//		PreparedStatement stmt = ConnectionManager.getConnection()
//				.prepareStatement("DELETE FROM groups WHERE name = ?;");
//		stmt.setString(1, name);
//
//		stmt.executeUpdate();
//		stmt.close();
//	}
	
	public static void renGroupByID(Integer id, String name) throws SQLException {
		PreparedStatement stmt = ConnectionManager.getConnection()
				.prepareStatement("UPDATE groups g SET g.name = ? WHERE g.id = ?;");
		stmt.setString(1, name);
		stmt.setInt(2, id);
		
		stmt.executeUpdate();
		stmt.close();
	}
}	