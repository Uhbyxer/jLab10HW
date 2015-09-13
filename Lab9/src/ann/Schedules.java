package ann;

import java.lang.annotation.Target;
import java.lang.annotation.Repeatable;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;


@Target(METHOD)
@Retention(RUNTIME)
public @interface Schedules {
  Schedule[] value();
}


@Target(METHOD)
@Retention(RUNTIME)
@Repeatable(Schedules.class)
@interface Schedule {
    String second() default "0";
    String minute() default "0";
}   


class A {
	
	@Schedule(second = "00")
	@Schedule(second = "09")
	void b() {
		
	}
}