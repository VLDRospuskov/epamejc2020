package main.HW_6;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.lang.reflect.Constructor;

@AllArgsConstructor
@ToString

public class User {

    private String name;
    private  int age;

    @MyAnnotation
    public User() throws NoSuchMethodException {
        Constructor constructor = User.class.getConstructor();

        this.name = constructor.getDeclaredAnnotation(MyAnnotation.class).name();
        this.age = constructor.getDeclaredAnnotation(MyAnnotation.class).age();    }

}
