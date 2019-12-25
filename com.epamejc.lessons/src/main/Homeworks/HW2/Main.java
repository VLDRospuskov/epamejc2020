package main.Homeworks.HW2;

import main.Homeworks.HW1.TrafficLight;

public class Main {
    public static void main(String[] args) {
        ImmutablePlane plane = new ImmutablePlane("Boeing", "737 MAX", 2018, 132);
        System.out.println("Plane Data: \n" + "Manufacturer: " + plane.getManufacturer() + "\nModel: " + plane.getModel());
    }
}
