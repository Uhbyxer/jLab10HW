package com.epam.lab9.annot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

//@Target(ElementType.TYPE)

public @interface Hints {
	Hint value();
}



@interface Hint {
    String value();
}

@Hints(@Hint("hint2"))
class A {	
}


