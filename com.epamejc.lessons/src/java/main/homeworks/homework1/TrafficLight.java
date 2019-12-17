package main.homeworks.homework1;
public class TrafficLight {
    private final static String green = "green";
    private final static String yellow ="yellow";
    private final static String red = "red";
    private String color;
    private double time;
    public void setColor(double requestTime){
        time = requestTime;
        disgardTime();
        if (0<=time && time<=3)
            color =green;
        else if(3<time && time<=5)
            color = yellow;
        else if (5<time && time<=10)
            color = red;
    }
    public String getColor(){
        return color;
    }
    private void disgardTime(){
        if (time>10) {
           time = time % 10;
           disgardTime();
        }
    }

}
