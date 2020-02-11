package homeworks.java.annotations;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Constructor;

@Data
@AllArgsConstructor
public class Person {

    private String name;
    private String age;

    @MyAnnotation(name = "John Doe", age = "unknown")
    public Person() {
        Constructor[] constructors = Person.class.getDeclaredConstructors();
        MyAnnotation annotation = (MyAnnotation) constructors[1].getAnnotation(MyAnnotation.class);
        this.name = annotation.name();
        this.age = annotation.age();
    }
}
