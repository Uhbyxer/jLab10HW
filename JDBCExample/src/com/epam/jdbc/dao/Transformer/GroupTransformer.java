package com.epam.jdbc.dao.Transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.jdbc.model.Group;

public class GroupTransformer {
	public static List<Group> getAllGroup(ResultSet rs) {
		List<Group> list = null; 
		try {
			while (rs.next()) {
				list = new ArrayList();
				Group gr = new Group();
					gr.setName(rs.getString("groupName"));
					gr.setId(rs.getInt("id"));
				list.add(gr);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
