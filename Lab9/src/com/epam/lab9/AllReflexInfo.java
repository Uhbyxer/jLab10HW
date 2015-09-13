
package com.epam.lab9;

import java.lang.reflect.*;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotation;

public class AllReflexInfo {

	public AllReflexInfo(Object obj) {
		Class<?> c = obj.getClass();
		System.out.println("Name: " + c.getName());
		
		
	     Method methods[] = c.getDeclaredMethods();
	       System.out.println("The  Employee methods:");

	       for (int i = 0; i < methods.length; i++){
	            System.out.println("*** Method Signature:" + 
	                                    methods[i].toString());
	       }

	       Class superClass = c.getSuperclass();
	       System.out.println("The name of the superclass is " 
	                                   + superClass.getName());

	       Method superMethods[] = superClass.getDeclaredMethods();
	       System.out.println("The superclass has:");

	       for (int i = 0; i < superMethods.length; i++){
	            System.out.println("*** Method Signature:" + 
	                               superMethods[i].toString());
	            System.out.println("      Return type: " + 
	                superMethods[i].getReturnType().getName());
	       }
	       
	       System.out.println("Constructors");
	       for (Constructor con: c.getConstructors()) {
	    	   System.out.println(con);
	       }
	       
	       System.out.println("Fields");
	       for(Field f: c.getDeclaredFields())
	    	   System.out.println(f);
		
	       
	       System.out.println("annotation");
	       for(java.lang.annotation.Annotation a: c.getAnnotations()) 
	    	   System.out.println(a);
	       
	       System.out.println("interfaces");
	       for(Class in: c.getInterfaces())
	    	   System.out.println(in);
	}
	
	public static void main(String[] args) {
		new AllReflexInfo(new Droid("Droid 1"));

	}

}


