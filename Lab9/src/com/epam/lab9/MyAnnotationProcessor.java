package com.epam.lab9;

import java.lang.reflect.*;

import com.epam.lab9.annot.DroidExecutor;
import com.epam.lab9.annot.DroidField;

public class MyAnnotationProcessor {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		Class<?> loadedClass = DroidBrowser.class;
		Object inst = loadedClass.newInstance();
		System.out.println("************************************************");
		System.out.println("class = " + loadedClass.getSimpleName());
		
		Method[] methods = loadedClass.getMethods();
		
		for(Method m: methods) {
			if(m.isAnnotationPresent(DroidExecutor.class)) {
				DroidExecutor exec = m.getAnnotation(DroidExecutor.class);
				System.out.println("==========================================");
				System.out.println("Method: " + m.getName());
				System.out.println("sqlStatement = " + exec.sqlStatement());
				System.out.println("transactionRequired = " + exec.transactionRequired());
				System.out.println("notifyOnUpdates = " + exec.notifyOnUpdates());
				
				/*Parameter[] params = m.getParameters();
				Object[] par = new Object[m.getParameterCount()];
				int i = 0;
				for(Parameter p: params) {
					System.out.println(p.getType().getName() +" "  + p.getName());
					try {
						par[i++] = p.getType().newInstance();
					} catch (InstantiationException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
				*/
				
				//m.invoke(inst, par);
				
			} else {
			}
		}
		
		
		loadedClass = Droid.class;
		System.out.println("************************************************");
		System.out.println("class = " + loadedClass.getSimpleName());
		
		
		Object instance = null;
			try {
				instance =  loadedClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		Field[] fields = loadedClass.getDeclaredFields();
		for(Field f: fields) {
			if(f.isAnnotationPresent(DroidField.class)) {
				DroidField field = f.getAnnotation(DroidField.class);
				System.out.println("============================================");
				System.out.println("Field: " + f.getName());
				System.out.println("imutable: " + field.imutable());
				
				if(f.getType() == String.class) {
					System.out.println("Setting string field to: No name");
					System.out.println("isAccessible: " + f.isAccessible())  ;
					try {
						f.setAccessible(true);
						f.set(instance, new String("No name"));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						System.out.println(f.get(instance));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
