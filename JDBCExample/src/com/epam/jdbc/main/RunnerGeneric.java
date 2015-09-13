package com.epam.jdbc.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.jdbc.dao.StudentDAO;
import com.epam.jdbc.dao.generic.GenericDao;
import com.epam.jdbc.dao.generic.GenericDaoImpl;
import com.epam.jdbc.model.Group;
import com.epam.jdbc.model.Language;
import com.epam.jdbc.model.Student;
import com.epam.jdbc.model.User;
import com.epam.jdbc.model.UserType;

public class RunnerGeneric {
	public static void main(String[] args) throws Exception {
		
//		Map<String , Object> map = new HashMap<>();
//		map.put("name", "%a%");
//		System.out.println(new GenericDaoImpl<UserType>().findAllByConditions(map, UserType.class));
		
//		UserType ut = new UserType();
//		ut.setId(1);
//		ut.setName("admin1111");
//		new GenericDaoImpl<UserType>().update(ut);
		
		
		//System.out.println(new GenericDaoImpl<User>().findAllByConditions(null, User.class));
		
		String sql = "SELECT u.id, u.first_name, u.user_type_id, ut.name AS 'user_type_name'  FROM user u " + 
		"JOIN user_type ut ON u.user_type_id = ut.id;";
		
		System.out.println("************************************");
		
		List<User> list = new GenericDaoImpl<User>().findAllByStatement(sql, null, User.class);
		
		list.forEach(System.out::println);
		
		
	}
	public static void printGroup(){
		 GenericDao<Group> studentDao = new GenericDaoImpl<Group>();
	        System.out.println("\n-------------?,--------------------");  
	        List<Group> books;
			try {
				books = studentDao.findAllByConditions(null, Group.class);
				  for (Group book : books) {  
			            System.out.println(book);  
			        }
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}
	public static void printStudent(){
		 GenericDao<Student> studentDao = new GenericDaoImpl<Student>();
	        System.out.println("\n-------------?,--------------------");  
	        List<Student> students;
			try {
				students = studentDao.findAllByConditions(null, Student.class);
				  for (Student st : students) {  
			            System.out.println(st);  
			        }
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}
	public static void inStudent() throws Exception{
		Student st = new Student();
		st.setBookNumber("123fhdj44");
		//st.setId(id);
		st.setFirstName("Бодак");
		st.setLastName("Роман");
		st.setCity("Рясне 2");
		st.setDepartmentID(2);
		st.setGroupID(2);
		GenericDao<Student> studentDao = new GenericDaoImpl<Student>();
		studentDao.save(st);
		
	}
}
