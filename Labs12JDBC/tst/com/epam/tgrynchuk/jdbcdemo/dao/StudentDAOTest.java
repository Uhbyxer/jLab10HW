package com.epam.tgrynchuk.jdbcdemo.dao;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.tgrynchuk.jdbcdemo.dao.StudentDAO;


public class StudentDAOTest {

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

	@Test
	public void testGetListOfStudentsByGroupID() throws SQLException {
		System.out.println(StudentDAO.getListOfStudentsByGroupID(3));
	}

}
