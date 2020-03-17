package com.epamejc.lessons.src.homework.homework6.annotation;

import lombok.Data;
import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

@Data
public class Person {
    private String name;
    private int age;

    @SneakyThrows
    @PersonInfo(name = "Rick", age = 90)
    Person() {
        PersonInfo annotation = getPersonInfo();
        this.name = annotation.name();
        this.age = annotation.age();
    }

    private PersonInfo getPersonInfo() throws NoSuchMethodException {
        Constructor<? extends Person> constructor = this.getClass().getDeclaredConstructor();
        return constructor.getAnnotation(PersonInfo.class);
    }
}
