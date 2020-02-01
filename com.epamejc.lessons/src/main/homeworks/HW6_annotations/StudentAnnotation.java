package main.homeworks.HW6_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)

public @interface StudentAnnotation {

    String name() default "SomeStudent";
    int age() default 20;
}
