package main.lessons.lesson9.solid.dependency;

import lombok.ToString;

@ToString
public class Animal {

    private String name;
    private String sound;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public void setName(String name) {
        this.name = name;
    }

}

