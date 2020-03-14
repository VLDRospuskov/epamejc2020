package Home_works.HW_6;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {

        User user = new User();
        System.out.println(user);

        Field name = user.getClass().getDeclaredField("name");
        name.setAccessible(true);
        Field age = user.getClass().getDeclaredField("age");
        age.setAccessible(true);

        System.out.println(name.get(user));
        System.out.println(age.get(user));
    }
}
