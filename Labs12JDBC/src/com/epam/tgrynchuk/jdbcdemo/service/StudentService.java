package com.epam.tgrynchuk.jdbcdemo.service;

import java.sql.SQLException;
import java.util.List;

import com.epam.tgrynchuk.jdbcdemo.dao.StudentDAO;
import com.epam.tgrynchuk.jdbcdemo.model.Student;

public class StudentService {
	public static List<Student> getListOfStudents() throws SQLException {
		return StudentDAO.getListOfStudents();
	}
}
