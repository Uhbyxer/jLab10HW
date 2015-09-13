package com.epam.tgrynchuk.jdbcdemo;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.tgrynchuk.jdbcdemo.model.Group;
import com.epam.tgrynchuk.jdbcdemo.model.Student;
import com.epam.tgrynchuk.jdbcdemo.service.GroupService;
import com.epam.tgrynchuk.jdbcdemo.service.StudentService;

public class JDBCDemo {

	public static void main(String[] args) throws NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		try {
			Group firstGroup = GroupService.getGroupByID(1);
			
			System.out.println("firstGroup = ");
			System.out.println(firstGroup);
			
			System.out.println("All groups:");
			System.out.println(GroupService.getListOfGroups());
			
			String newGroupName = "TMP_GROUP";
			System.out.println("New group: " + newGroupName);
			GroupService.newGroup(newGroupName);
			System.out.println("All groups:");
			System.out.println(GroupService.getListOfGroups());
			
			System.out.println("Del group: " + newGroupName);
			GroupService.delGroupByName(newGroupName);
			System.out.println("All groups:");
			System.out.println(GroupService.getListOfGroups());
			
			newGroupName = "Укр";
			System.out.println("Rename 6 to: " + newGroupName);
			GroupService.renGroupByID(6, newGroupName);
			System.out.println("All groups:");
			System.out.println(GroupService.getListOfGroups());
			
			System.out.println("All students");
			List<Student> students = new ArrayList<Student>();
			students = StudentService.getListOfStudents();
			students.forEach(System.out::println);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
