package com.epam.tgrynchuk.jdbcdemo.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.epam.tgrynchuk.jdbcdemo.model.Group;
import com.epam.tgrynchuk.jdbcdemo.model.Student;

public class GroupDAOTest {
	
	private static Integer fromID = 1;
	private static Integer toID = 6;

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
	public void testRemoveStudents() throws SQLException {
		 
		
		Group fromGroup = GroupDAO.getGroupByID(fromID);
		System.out.println("Our group: \n" + fromGroup);
		List<Student> students = StudentDAO.getListOfStudentsByGroup(fromGroup);
		System.out.println("Students:\n" + students);
		
		
		Group toGroup = GroupDAO.getGroupByID(toID);
		System.out.println("To group: " + toGroup);
		System.out.println("Students:\n" + StudentDAO.getListOfStudentsByGroup(toGroup));
		
		System.out.println("removing students ......");
		StudentDAO.removeStudentsToNewGroup(students, toGroup);
		
		System.out.println("Our group :  " + fromGroup + "\nStudents:\n" + StudentDAO.getListOfStudentsByGroup(fromGroup));
		System.out.println("To group :  " + toGroup + "\nStudents:\n" + StudentDAO.getListOfStudentsByGroup(toGroup));
		System.out.println("------------------------------------------");
		
		System.out.println("Delete " + fromGroup);
		GroupDAO.delGroupByID(fromGroup.getId());
		
		System.out.println("Our group after delete: " + GroupDAO.getGroupByID(fromGroup.getId()));
		
		
	}
	
	@Ignore
	@Test
	public void showStudents() throws SQLException {
		Group fromGroup = GroupDAO.getGroupByID(fromID);
		System.out.println("Our group: \n" + fromGroup);
		List<Student> students = StudentDAO.getListOfStudentsByGroup(fromGroup);
		System.out.println("Students:\n" + students);
		
		Group toGroup = GroupDAO.getGroupByID(toID);
		System.out.println("To group: " + toGroup);
		System.out.println("Students:\n" + StudentDAO.getListOfStudentsByGroup(toGroup));
	}

}
