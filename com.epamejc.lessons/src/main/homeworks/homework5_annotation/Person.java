package homeworks.homework5_annotation;

import lombok.Getter;

import java.lang.reflect.Constructor;

@Getter
public class Person {
    int age;
    String name;

    @MyAnnotation()
    public Person() {

        MyAnnotation annotation = getAnnotation();
        this.age = annotation.age();
        this.name = annotation.name();
    }

    private MyAnnotation getAnnotation() {
        Class mPerson = Person.class;
        Constructor[] constructors = mPerson.getConstructors();
        return (MyAnnotation) constructors[0].getAnnotation(MyAnnotation.class);
    }

}
