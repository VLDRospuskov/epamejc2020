package homeworks.java.annotations.utils;

import homeworks.java.annotations.MyAnnotation;
import homeworks.java.annotations.Person;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * The util, used to set private fields of {@link homeworks.java.annotations.Person} with values
 * stored in {@link homeworks.java.annotations.MyAnnotation}
 *
 * @author Vladimir Ivanov
 */
public class PersonReflectiveDefaults {

    @SneakyThrows
    public static void setDefault(Person person) {

        MyAnnotation myAnnotation = person.getClass().getAnnotation(MyAnnotation.class);
        Field[] declaredFields = person.getClass().getDeclaredFields();
        declaredFields[0].setAccessible(true);
        declaredFields[0].set(person, myAnnotation.name());
        declaredFields[1].setAccessible(true);
        declaredFields[1].set(person, myAnnotation.age());

    }

}
