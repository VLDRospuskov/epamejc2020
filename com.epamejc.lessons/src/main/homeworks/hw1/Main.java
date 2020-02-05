package main.homeworks.hw1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        TrafficLight light = new TrafficLight();
        light.getLight(buffer);

    }

}
