package com.epam.tgrynchuk.jdbcdemo.treansformer;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.tgrynchuk.jdbcdemo.annot.Field;
import com.epam.tgrynchuk.jdbcdemo.annot.Operations;
import com.epam.tgrynchuk.jdbcdemo.model.Group;

public class GenericTransformer {
	public static <T> List<T> ResultSetToListOfObjects(ResultSet rs, Class<T> cls) throws SQLException, InstantiationException, IllegalAccessException, NumberFormatException, IllegalArgumentException, InvocationTargetException  {
		List<T> res = new ArrayList<T>();
		
		Map<String, Method> methHolder = new HashMap<>();
		
		Method[] methods = cls.getMethods();
		
		for(Method method: methods) {
			if(!method.isAnnotationPresent(Field.class)) 
				continue;
			
			Field f = method.getAnnotation(Field.class);
			if(f.type() != Operations.SET) 
				continue;
				
			methHolder.put(f.fieldName(), method);
		}
		
		while(rs.next()) {
			Object instance = cls.newInstance();
			
			int colNum = rs.getMetaData().getColumnCount();
			
			for(int i = 1; i <= colNum; i++) {
				Method meth = methHolder.getOrDefault(rs.getMetaData().getColumnName(i), null);
				if(meth == null) 
					continue;
				
				Parameter[] pars = meth.getParameters();
				
	            if(pars.length != 1) continue;
	            	
	            	
				if (pars[0].getType() == int.class || pars[0].getType() == Integer.class)
					meth.invoke(instance, Integer.parseInt(rs.getObject(i).toString()));
				else if (pars[0].getType() == String.class)
					meth.invoke(instance, rs.getObject(i).toString());
					
				
			}
			
			res.add((T) instance);
			
		}
		
		
		return res;
	}
}
