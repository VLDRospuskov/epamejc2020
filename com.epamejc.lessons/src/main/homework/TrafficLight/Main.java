package homework.TrafficLight;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            TrafficLightsBuffRd.colorCheck(reader);
        }
    }

    public static void runJOption() {
        double time;
        String userData;
        while (true) {
            userData = JOptionPane.showInputDialog("Введите число: ");
            try {
                time = Double.parseDouble(userData);
            } catch (Exception e) {
                continue;
            }
            TrafficLights.colorCheck(time);
        }
    }
}