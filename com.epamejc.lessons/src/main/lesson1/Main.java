package main.lesson1;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        double time;
        String userData;
        while (true) {
            userData = JOptionPane.showInputDialog("Введите число: ");
            try {
                time = Double.parseDouble(userData);
            } catch (Exception e){
                continue;
            }
            TrafficLights.colorCheck(time);
        }
    }
}
