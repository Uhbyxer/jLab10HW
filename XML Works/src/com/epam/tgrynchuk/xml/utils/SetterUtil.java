package com.epam.tgrynchuk.xml.utils;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;





public class SetterUtil<T> {
	//private Class<T> cls;
	
	private Map<String, Method> methHolder;
	
	public SetterUtil(Class<T> cls) {
		//this.cls = cls;
		
		methHolder = new HashMap<>();
		
		Method[] methods = cls.getMethods();

		for(Method method: methods) {
			if(method.isAnnotationPresent(Setter.class)) {
				Setter f = method.getAnnotation(Setter.class);
				methHolder.put(f.value().toLowerCase(), method);
			}
		}		
	}
	
	public boolean set(T instance, String field, Object value) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Method meth = methHolder.getOrDefault(field.toLowerCase(), null);
		if(meth == null) 
			return false;
		
		Parameter[] pars = meth.getParameters();
		
        if(pars.length != 1) return false;
        	
        	
		if (pars[0].getType() == int.class || pars[0].getType() == Integer.class)
			meth.invoke(instance, Integer.parseInt(value.toString()));
		else if (pars[0].getType() == String.class)
			meth.invoke(instance, value.toString());		
		
		return true;
	}
	
}
