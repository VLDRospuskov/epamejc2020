package homeworks.homework5_annotation;

import lombok.Getter;

import java.lang.reflect.Constructor;

@Getter
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
