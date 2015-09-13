package com.epam.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.epam.jdbc.connection.ConnectionManager;
import com.epam.jdbc.dao.Transformer.GroupTransformer;
import com.epam.jdbc.model.Group;

public class GroupDAO {
	public static int insertGroup(Group group){
		int result = 0;
		String sql = "insert into groupDep(groupName) values(?)";
		try {
			PreparedStatement ps = ConnectionManager.getInstanse().getConnection().prepareStatement(sql);
			ps.setString(1, group.getName());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static int delete(Integer id){
		int result = 0;
		String sql = "delete from groupDep where id = ?";
		try {
			PreparedStatement ps = ConnectionManager.getInstanse().getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Group> getAllGroup(){
		List<Group> listResult = null;
		String sql = "select * from groupDep";
		Statement st;
		try {
			st = ConnectionManager.getInstanse().getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			listResult = GroupTransformer.getAllGroup(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listResult;	
	}
	
	public static void main(String[] args) {
		System.out.println(new GroupDAO().getAllGroup());
	}
}
