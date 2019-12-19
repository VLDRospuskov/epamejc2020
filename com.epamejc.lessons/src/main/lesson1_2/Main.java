package main.lesson1_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            TrafficLightsBuffRd.colorCheck(reader);
        }
    }
}
