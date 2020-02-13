package homeworks.java.annotations;

import homeworks.java.annotations.utils.PersonReflectiveDefaults;

/**
 * Simple program for annotations and reflection test. <br>
 * The goal is to get data, stored in annotation, using reflection
 * and to set created with no args constructor object fields with this data. <br>
 * We have a class with no args constructor, private fields and without any setter.
 *
 * @author Vladimir Ivanov
 */
public class Main {

    public static void main(String[] args) {

        Person person = new Person();
        System.out.println(person);
        PersonReflectiveDefaults.setDefault(person);
        System.out.println(person);

    }

}
