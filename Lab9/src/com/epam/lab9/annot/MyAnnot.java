package com.epam.lab9.annot;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Inherited
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface MyAnnot {

	java.lang.Class annot();
}

@Retention(RetentionPolicy.RUNTIME)

@Target(value={ElementType.METHOD})

@interface InitializingMethod{
	String name();
}

@Deprecated
class MyClass {
	@MyAnnot(annot = MyAnnot.class)
	void Some() {
		
	}
}

@Target({ElementType.ANNOTATION_TYPE})
@interface MyAnnot1 {
}


@MyAnnot1
@interface MyAnnot2 {
	
}



