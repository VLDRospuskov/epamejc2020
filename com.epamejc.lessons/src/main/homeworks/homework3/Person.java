package main.homeworks.homework3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.lang.reflect.Constructor;
@Data
@ToString
@EqualsAndHashCode
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
