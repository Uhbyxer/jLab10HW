package com.epam.tgrynchuk.jdbcdemo.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.tgrynchuk.jdbcdemo.model.Group;
import com.epam.tgrynchuk.jdbcdemo.model.Speciality;
import com.epam.tgrynchuk.jdbcdemo.model.Student;
import com.epam.tgrynchuk.jdbcdemo.persistant.ConnectionManager;

public class StudentDAO {
	
	private static final String SQL_ALL = 
			"SELECT   s.id, s.name, s.surname, " +
	                 "g.id AS group_id, g.name AS group_name, " +
			         "s1.id AS spec_id, s1.name AS spec_name " +
			"FROM students s " +
			"JOIN groups g ON s.group_id = g.id JOIN specialities s1 ON s.spec_id = s1.id;";
	
	private static final String SQL_STUDENTS_BY_GROUP = 
			"SELECT   s.id, s.name, s.surname, " +
	                 "g.id AS group_id, g.name AS group_name, " +
			         "s1.id AS spec_id, s1.name AS spec_name " +
			"FROM students s " +
			"JOIN groups g ON s.group_id = g.id JOIN specialities s1 ON s.spec_id = s1.id " +
			"WHERE s.group_id = ?;";

	private static final String SQL_REMOVE_STUDENTS_TO_GROUP = 
			"UPDATE students s SET s.group_id = ? WHERE s.group_id IN (?);";
	
	private static final String SQL_REMOVE_ONE_STUDENT_TO_GROUP = 
			"UPDATE students s SET s.group_id = ? WHERE s.group_id = ?;";	
	
	public static List<Student> getListOfStudents() throws SQLException {
		List<Student> res = new ArrayList<Student>();
		
		PreparedStatement stmt = ConnectionManager.getConnection()
				.prepareStatement(SQL_ALL);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Student student = new Student();
			
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setSurname(rs.getString("surname"));
			student.setSpeciality(new Speciality(rs.getInt("spec_id"), rs.getString("name"), ""));
			student.setGroup(new Group(rs.getInt("group_id"), rs.getString("group_name")));
			
			res.add(student);
		}
		
		rs.close();
		stmt.close();		
		return res;
	}
	
	public static List<Student> getListOfStudentsByGroupID(Integer groupID) throws SQLException {
		List<Student> res = new ArrayList<Student>();
		
		PreparedStatement stmt = ConnectionManager.getConnection()
				.prepareStatement(SQL_STUDENTS_BY_GROUP);
		stmt.setInt(1, groupID);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Student student = new Student();
			
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setSurname(rs.getString("surname"));
			student.setSpeciality(new Speciality(rs.getInt("spec_id"), rs.getString("name"), ""));
			student.setGroup(new Group(rs.getInt("group_id"), rs.getString("group_name")));
			
			res.add(student);
		}
		
		rs.close();
		stmt.close();		
		return res;
	}
	
	public static List<Student> getListOfStudentsByGroup(Group group) throws SQLException {
		return getListOfStudentsByGroupID(group.getId());
	}
	
	public static void removeStudentsToNewGroup(List<Student> students, Integer groupID) throws SQLException {
		if(students.isEmpty()) return;
		
//		Connection conn = ConnectionManager.getConnection();
//
//		PreparedStatement stmt = conn
//				.prepareStatement(SQL_REMOVE_STUDENTS_TO_GROUP);
//		List<Integer> list = new ArrayList<Integer>();
//		for (Student s : students) {
//			list.add(s.getId());
//		}
//
//		Array array = conn.createArrayOf("VARCHAR", list.toArray());
//		stmt.setArray(2, array);
//		stmt.setInt(1, groupID);        

		
		Connection conn = ConnectionManager.getConnection();
		//conn.setAutoCommit(false);
		
		PreparedStatement stmt = null;
		
		for(Student s: students) {
		
			stmt = conn.prepareStatement(SQL_REMOVE_ONE_STUDENT_TO_GROUP);		
			stmt.setInt(1, groupID);
			stmt.setInt(2, s.getId());
			stmt.executeUpdate();
        
        }
		//conn.commit();
		//conn.setAutoCommit(true);
		stmt.close();
	}
	
	public static void removeStudentsToNewGroup(List<Student> students, Group group) throws SQLException {
		removeStudentsToNewGroup(students, group.getId());
	}
	
	
}
