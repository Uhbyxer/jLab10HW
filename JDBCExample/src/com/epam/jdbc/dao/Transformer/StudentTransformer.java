package com.epam.jdbc.dao.Transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.jdbc.model.Student;

public class StudentTransformer {
	public static List<Student> getStudentByName(ResultSet rs){
		List<Student> students = null;
		try {
			while (rs.next()){
				students = new ArrayList<Student>();
				Student student = new Student();
				student.setFirstName(rs.getString("firstName"));
				student.setLastName(rs.getString("lastName"));
				student.setBookNumber(rs.getString("bookNumber"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	public static List<Student> getAllStudent(ResultSet rs) {
		List<Student> list = null; 
		try {
			while (rs.next()) {
				list = new ArrayList<Student>();
				Student gr = new Student();
					gr.setFirstName(rs.getString("firstName"));
					gr.setId(rs.getInt("id"));
				list.add(gr);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
