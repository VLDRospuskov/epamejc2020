package main.homeworks.hw6;

import lombok.Data;

import java.lang.reflect.Constructor;

@Data
public class Person {
    
    private String name;
    private Integer age;

    @InformationAnnotation
    public Person() {
        Class<Person> personClass = Person.class;
        Constructor[] constructors = personClass.getConstructors();
        InformationAnnotation annotation =
                                    (InformationAnnotation)constructors[0].getAnnotation(InformationAnnotation.class);
        this.name = annotation.name();
        this.age = annotation.age();
    }

}
