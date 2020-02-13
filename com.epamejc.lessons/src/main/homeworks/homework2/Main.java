package main.homeworks.homework2;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        ImmutableClass person = new ImmutableClass("Arina", 21, 1.75, new Date());
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getHeight());
        System.out.println(person.getDateOfBirth());
    }

}
