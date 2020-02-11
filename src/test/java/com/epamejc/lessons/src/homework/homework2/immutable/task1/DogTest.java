package com.epamejc.lessons.src.homework.homework2.immutable.task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DogTest {

    @Test
    public void testToString() {
        String name = "Sharik";
        int age = 13;
        String breed = "Pug";
        Dog dog = new Dog(name, age, breed);
        String expectedToString = "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                '}';
        String actualToString = dog.toString();
        assertEquals(expectedToString, actualToString);
    }

    @Test
    public void getName() {
        String name = "name";
        int age = 23;
        String breed = "sadas";
        Dog dog = new Dog(name, age, breed);
        String actualName = dog.getName();
        assertEquals(name, actualName);
    }

    @Test
    public void getAge() {
        String name = "asdf";
        int age = 0;
        String breed = "sadas";
        Dog dog = new Dog(name, age, breed);
        int actualAge = dog.getAge();
        assertEquals(age, actualAge);
    }

    @Test
    public void getBreed() {
        String name = "asdf";
        int age = 23;
        String breed = "breead";
        Dog dog = new Dog(name, age, breed);
        String actualBreed = dog.getBreed();
        assertEquals(breed, actualBreed);
    }
}