package com.epam.lab9;


import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
public class ReflectionSample {
  @SuppressWarnings("rawtypes")
public static void main(String args[]) {
     try {
       Class c = Class.forName("com.epam.lab9.Droid");
       Method methods[] = c.getDeclaredMethods();
       System.out.println("The  Employee methods:");

       for (int i = 0; i < methods.length; i++){
            System.out.println("*** Method Signature:" + 
                                    methods[i].toString());
            
            
            List<Object> par = new ArrayList<>();
            Parameter[] pars = methods[i].getParameters();
            
            if(pars.length == 0) 
            	methods[i].invoke(c.newInstance(), null);
            
            for(Parameter p: pars) {
            	par.add(null);
            }
            
            if(pars.length == 1) {
            	if(pars[0].getType() == int.class || pars[0].getType() == Integer.class)
            		methods[i].invoke(c.newInstance(), new Integer[] {5});
            }
            
            if(methods[i].isVarArgs()) {
            	System.out.println("isVarArgs");
            	
            	
            	if(methods[i].getParameters()[0].isVarArgs())
            		if(methods[i].getParameters()[0].getType().getSimpleName().startsWith("String")) {
            			methods[i].invoke(c.newInstance(), Array.newInstance(String.class, 2));
            		}
            	
            	if(methods[i].getParameters()[0].getType() == String.class  && methods[i].getParameters()[1].isVarArgs()) {
            		if(methods[i].getParameters()[1].getType().getSimpleName().startsWith("int")) {
            			methods[i].invoke(c.newInstance(), new String("Enemy droid") ,Array.newInstance(int.class, 2)  );
            		}
            	}
            }
            
            //methods[i].invoke(c.newInstance(), par.toArray());
            
       }

       
       /*
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
       */
       
       /*
       Class parameterTypes[]= new Class[] {String.class};
       
    @SuppressWarnings("unchecked")
	Method myMethod = c.getMethod( "changeAddress", parameterTypes);

       Object arguments[] = new Object[1];
       arguments[0] = "250 Broadway";
       myMethod.invoke(c.newInstance(),arguments);

       */
       
       

     } catch (Exception e) {
           e.printStackTrace();
     }
  }
}
