package main.lessons.lesson7.example8;

public enum Shape {
    RECTANGLE("red"), TRIANGLE("green"), CIRCLE("blue");

    String color;

    Shape(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }
}
