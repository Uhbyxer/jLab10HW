package com.epam.jdbc.dao.service;

import java.util.List;

import com.epam.jdbc.dao.StudentDAO;
import com.epam.jdbc.model.Student;

public class StudentService {
	public static List<Student> getStudentByName(String name){
		return StudentDAO.getStudentByName(name);
	}
}
