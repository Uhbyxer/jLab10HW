package com.epam.lab9.annot;

import java.lang.annotation.*;


@Inherited
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DroidExecutor {
	String sqlStatement();
	boolean transactionRequired() default false;
	boolean notifyOnUpdates() default false;
	java.lang.Class clazz() default Exception.class;
}
