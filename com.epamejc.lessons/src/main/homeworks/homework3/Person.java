package main.homeworks.homework3;
import lombok.Data;
import java.lang.reflect.Constructor;
@Data
public class Person {
    int age;
    String name;
    @MyAnnotation()
    public Person(){
        Class mPerson = Person.class;
        Constructor[] constructors = mPerson.getConstructors();
        MyAnnotation annotation = (MyAnnotation)constructors[0].getAnnotation(MyAnnotation.class);
        this.age = annotation.age();
        this.name = annotation.name();
    }
}
