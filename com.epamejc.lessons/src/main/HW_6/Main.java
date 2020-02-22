package main.HW_6;

import java.lang.reflect.Field;

/**
 * Создать свою кастомную аннотацию где будет "имя - string" и "возраст - int",
 * то есть в аннотации передаем (name = "sdgf", age = "12").
 * Повесить аннотацию на конструктор.
 * Цель сделать так чтобы когда у нас будет создаваться объект по типу
 * Person person = new Person() - конструктор пустой,
 * через рефлексию мы должны достать данные из аннотации
 * и подсунуть при инициализации объекта name и age из аннотации.
 * Используйте ломбок.
 */

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
