package homework6.task1;

import java.lang.reflect.Field;

public class Launcher {

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {

        Person person = new Person();
        System.out.println(person);

        Field name = person.getClass().getDeclaredField("name");
        name.setAccessible(true);
        Field age = person.getClass().getDeclaredField("age");
        age.setAccessible(true);

        System.out.println(name.get(person));
        System.out.println(age.get(person));
    }
}
