package homework6.task1;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.lang.reflect.Constructor;

@AllArgsConstructor
@ToString
class Person {

    private String name;
    private int age;

    @MyAnnotation
    public Person() throws NoSuchMethodException {
        Constructor constructor = Person.class.getConstructor();

        this.name = constructor.getDeclaredAnnotation(MyAnnotation.class).name();
        this.age = constructor.getDeclaredAnnotation(MyAnnotation.class).age();

    }
}
