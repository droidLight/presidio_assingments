package day12;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface PaintAnnotation {
	String value() default "hello world";
}
