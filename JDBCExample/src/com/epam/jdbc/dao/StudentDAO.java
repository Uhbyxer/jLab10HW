package com.epam.jdbc.dao;
 
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.jdbc.connection.ConnectionManager;
import com.epam.jdbc.dao.Transformer.GroupTransformer;
import com.epam.jdbc.dao.Transformer.StudentTransformer;
import com.epam.jdbc.model.Group;
import com.epam.jdbc.model.Student;

public class StudentDAO {
	public static List<Student> getStudentByName(String name){
		List<Student> students = null;
		String sql = "select * from student where lastName = ?";
		try{
			PreparedStatement ps = ConnectionManager.getInstanse().getConnection().prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				students = new ArrayList<Student>();
				Student student = new Student();
				student.setFirstName(rs.getString("firstName"));
				student.setLastName(rs.getString("lastName"));
				student.setBookNumber(rs.getString("bookNumber"));
				
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return students;
	}
	public static int transferStudentFromDepartment(int departmentFrom, int departmentTo){
		int result = 0;
		String sql = "update student set departmentID = ? where departmentID = ?";
		try {
			PreparedStatement ps = ConnectionManager.getInstanse().getConnection().prepareStatement(sql);
			ps.setInt(1, departmentTo);
			ps.setInt(2, departmentFrom);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static int insertGroup(String firstName, String lastName, String city, String bookNumber, int groupID){
		int result = 0;
		String sql = "insert into Student(firstName, lastName, city, bookNumber, groupID) values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = ConnectionManager.getInstanse().getConnection().prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, city);
			ps.setString(4, bookNumber);
			ps.setInt(5, groupID);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static List<Student> getAllStudent(){
		List<Student> listResult = null;
		String sql = "select * from student";
		Statement st;
		try {
			st = ConnectionManager.getInstanse().getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			listResult = StudentTransformer.getAllStudent(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listResult;	
	}
	public static int transaction(){
		int result = 0;
		try {
			CallableStatement ps = ConnectionManager.getInstanse().getConnection().prepareCall("{call pr1(?,?)} ");
			ps.setInt(1, 12);
			ps.setInt(2, 6);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
