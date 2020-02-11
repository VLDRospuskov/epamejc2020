package com.epamejc.lessons.src.homework.homework6.annotation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void checkFields() {
        Person person = new Person();
        String expectedName = "Rick";
        String actualName = person.getName();
        assertEquals(expectedName, actualName);
        int expectedAge = 90;
        int actualAge = person.getAge();
        assertEquals(expectedAge, actualAge);
    }

}