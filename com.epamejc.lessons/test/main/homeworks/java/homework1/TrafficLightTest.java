package main.homeworks.java.homework1;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;
import static main.homeworks.java.homework1.Lights.*;
public class TrafficLightTest {


    private TrafficLight trafficLight = new TrafficLight();;

    @Test
    public void TestChangeLight() {
        String[] input = "123 656575 488 234234 22222".split(" ");
        Lights[] expected = { GREEN, GREEN, RED, YELLOW, GREEN };
        Lights[] actual = new Lights[expected.length];
        for (int i = 0; i < expected.length; i++) {
            actual[i] = trafficLight.changeLight(input[i]);
        }

        assertArrayEquals(expected, actual);
    }
}