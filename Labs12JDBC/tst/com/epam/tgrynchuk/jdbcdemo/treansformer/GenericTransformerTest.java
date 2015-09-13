package com.epam.tgrynchuk.jdbcdemo.treansformer;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.epam.tgrynchuk.jdbcdemo.model.Group;
import com.epam.tgrynchuk.jdbcdemo.persistant.ConnectionManager;

public class GenericTransformerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//@Ignore
	@Test
	public void testMethods() throws SQLException, NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<Group> res = new ArrayList<Group>();
		
		PreparedStatement stmt = ConnectionManager.getConnection()
				.prepareStatement("SELECT * FROM groups");
		
		ResultSet rs = stmt.executeQuery();
		
		
		
		List<Group> group =  GenericTransformer.ResultSetToListOfObjects( rs, Group.class);
		System.out.println(group);
		
		
//		while(rs.next()) {
//			res.add(new Group(rs.getInt("id"), rs.getString("name")));
//		}
		
		rs.close();
		stmt.close();		
		
		
		
	}

}
