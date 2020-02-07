package homeworks.java.annotations;

import lombok.Data;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

@Data
public class Person {

    private String name;
    private String age;

    @MyAnnotation(name = "John Doe", age = "unknown")
    public Person() {
       Constructor[] constructors = Person.class.getDeclaredConstructors();
       MyAnnotation annotation = (MyAnnotation) constructors[0].getAnnotation(MyAnnotation.class);
       this.name = annotation.name();
       this.age = annotation.age();
    }
}
