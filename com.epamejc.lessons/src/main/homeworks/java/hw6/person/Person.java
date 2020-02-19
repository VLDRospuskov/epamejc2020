package homeworks.java.hw6.person;

import homeworks.java.hw6.annotations.CustomAnnotation;
import lombok.Data;

import java.lang.reflect.Constructor;

@Data
public class Person {

    private String name;
    private int age;

    @CustomAnnotation(name = "sdgf", age = 12)
    Person() {
        replaceValues();
    }

    Constructor[] declaredConstructors = Person.class.getDeclaredConstructors();

    private void replaceValues(){
        CustomAnnotation annotation = (CustomAnnotation) declaredConstructors[0].getAnnotation(CustomAnnotation.class);
        this.name = annotation.name();
        this.age = annotation.age();
    }

}
